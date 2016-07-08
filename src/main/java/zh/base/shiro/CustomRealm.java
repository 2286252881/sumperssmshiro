package zh.base.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import zh.base.pojo.po.ActiveUser;
import zh.base.pojo.po.Tpermission;
import zh.base.pojo.po.Tuser;
import zh.base.pojo.vo.Menu;
import zh.base.service.SysService;

public class CustomRealm extends AuthorizingRealm {
	
	
	@Autowired private SysService sysService;
	
	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}
	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//第一步从token中取出身份凭证
		String username=(String) token.getPrincipal();
		Tuser tuser=null;
		try {
			tuser=sysService.findSysUserByUserName(username);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(tuser==null){
			return null;
		}
		String password=tuser.getPwd();
		
		String salt=tuser.getSalt();
		
		
		ActiveUser activeUser=new ActiveUser();
		activeUser.setUserid(tuser.getId());
		activeUser.setUsername(tuser.getUsername());
		activeUser.setUsercode(tuser.getUsercode());
		//根据id取出菜单
		//通过sysservice取出菜单
		List<Menu> menus=null;
		try {
			menus=sysService.findMenuListByUserId(tuser.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将用户菜单设置到当前用户
		activeUser.setMenus(menus);
		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(activeUser, password,ByteSource.Util.bytes(salt),this.getName());
		return simpleAuthenticationInfo;
	}
	//用于授权 
	@SuppressWarnings("unused")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//从principals获取主身份信息
		ActiveUser activeUser=(ActiveUser) principals.getPrimaryPrincipal();
		List<Tpermission> tpermissionList=null;
		try {
			tpermissionList=sysService.findPermissionListByUserId(activeUser.getUserid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> permissions=new ArrayList<String>();
		for (Tpermission tpermission : tpermissionList) {
			permissions.add(tpermission.getPercode());
		}
		if(permissions.size()==0){
			permissions.add("no_permissions");
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		
		return simpleAuthorizationInfo;
	}
	//清除缓存
		public void clearCached() {
			PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
			super.clearCache(principals);
		}
}
