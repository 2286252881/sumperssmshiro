package zh.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName("CustomRealm");
	}
	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		
		
		
		//第一步从token中取出身份凭证
		String userCode=(String) token.getPrincipal();
		
		
		//第二步根据用户的的凭证userCode从数据库中去查询
		//模拟从数据库中取得的密码
		String pwd="111112";
		
		//如果查询不到
//		if(!userCode.equals("zhangsan")){
//			
//			return null;
//		}
		//如果查询到返回认证信息AuthenticationInfo
		
		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, pwd, this.getName());
		return simpleAuthenticationInfo;
	}
	//用于授权 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//从principals获取主身份信息
		String userCode=(String) principals.getPrimaryPrincipal();
		//根据身份信息获取权限信息
		//连接数据库.....
		List<String> permissions=new ArrayList<String>();
		permissions.add("user:create");
		permissions.add("items:add");
		//.....
		
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		//将从数据库查询到的授权信息填充到SimpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);
		
		return simpleAuthorizationInfo;
	}
	
}
