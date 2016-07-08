package zh.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomRealmMD5 extends AuthorizingRealm {
	
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
		String pwd="36f2dfa24d0a9fa97276abbe13e596fc";//散列2次后的密码
		//从数据库获取的盐
		String salt="qwerty";
		
		//如果查询不到
//		if(!userCode.equals("zhangsan")){
//			
//			return null;
//		}
		//如果查询到返回认证信息AuthenticationInfo
		
		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, pwd,ByteSource.Util.bytes(salt), this.getName());
		return simpleAuthenticationInfo;
	}
	//用于授权 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	
}
