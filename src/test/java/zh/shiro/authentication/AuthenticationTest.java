package zh.shiro.authentication;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
/**
 * 
 * @author Administrator
 * 执行流程
 * 1、通过ini配置文件创建securityManager
	2、调用subject.login方法主体提交认证，提交的token
	3、securityManager进行认证，securityManager最终由ModularRealmAuthenticator进行认证。
	4、ModularRealmAuthenticator调用IniRealm(给realm传入token) 去ini配置文件中查询用户信息
	5、IniRealm根据输入的token（UsernamePasswordToken）从 shiro-first.ini查询用户信息，根据账号查询用户信息（账号和密码）
		如果查询到用户信息，就给ModularRealmAuthenticator返回用户信息（账号和密码）
		如果查询不到，就给ModularRealmAuthenticator返回null
	6、ModularRealmAuthenticator接收IniRealm返回Authentication认证信息
		如果返回的认证信息是null，ModularRealmAuthenticator抛出异常（org.apache.shiro.authc.UnknownAccountException）
		如果返回的认证信息不是null（说明inirealm找到了用户），对IniRealm返回用户密码 （在ini文件中存在）和 token中的密码 进行对比，如果不一致抛出异常（org.apache.shiro.authc.IncorrectCredentialsException）
 *
 */
public class AuthenticationTest {
	@Test
	public void testLoginAndLogout(){
		//通过ini配置文件创建SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("shiro.ini");
		//创建SecurityManager
		SecurityManager securityManager=factory.getInstance();
		//将SecurityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		//从SecurityUtils中创建一个subject对象
		Subject subject=SecurityUtils.getSubject();
		
		//在认证提交前准备token(令牌)
		UsernamePasswordToken token=new UsernamePasswordToken("1", "2323");
		try {
			//执行认证提交
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		//是否认证通过
		boolean  isAuthenticated=subject.isAuthenticated();
		System.out.println("是否认证通过!"+isAuthenticated);
		
		//退出操作
		subject.logout();
		
		//是否认证通过
		isAuthenticated=subject.isAuthenticated();
		System.out.println("是否认证通过!"+isAuthenticated);
				
	}
	
	@Test
	public void testCustomRealm(){
		//通过ini配置文件创建SecurityManager工厂
				Factory<SecurityManager> factory=new IniSecurityManagerFactory("shiro-realm.ini");
				//创建SecurityManager
				SecurityManager securityManager=factory.getInstance();
				//将SecurityManager设置到运行环境中
				SecurityUtils.setSecurityManager(securityManager);
				//从SecurityUtils中创建一个subject对象
				Subject subject=SecurityUtils.getSubject();
				
				//在认证提交前准备token(令牌)
				UsernamePasswordToken token=new UsernamePasswordToken("1", "111111");
				try {
					//执行认证提交
					subject.login(token);
				} catch (AuthenticationException e) {
					e.printStackTrace();
				}
				//是否认证通过
				boolean  isAuthenticated=subject.isAuthenticated();
				System.out.println("是否认证通过!"+isAuthenticated);
				
				//退出操作
				subject.logout();
				
				//是否认证通过
				isAuthenticated=subject.isAuthenticated();
				System.out.println("是否认证通过!"+isAuthenticated);
	}
	
	@Test
	public void testCustomRealmMD5(){
		//通过ini配置文件创建SecurityManager工厂
				Factory<SecurityManager> factory=new IniSecurityManagerFactory("shiro-realm-md5.ini");
				//创建SecurityManager
				SecurityManager securityManager=factory.getInstance();
				//将SecurityManager设置到运行环境中
				SecurityUtils.setSecurityManager(securityManager);
				//从SecurityUtils中创建一个subject对象
				Subject subject=SecurityUtils.getSubject();
				
				//在认证提交前准备token(令牌)
				UsernamePasswordToken token=new UsernamePasswordToken("1", "111111");
				try {
					//执行认证提交
					subject.login(token);
				} catch (AuthenticationException e) {
					e.printStackTrace();
				}
				//是否认证通过
				boolean  isAuthenticated=subject.isAuthenticated();
				System.out.println("是否认证通过!"+isAuthenticated);
				
				//退出操作
				subject.logout();
				
				//是否认证通过
				isAuthenticated=subject.isAuthenticated();
				System.out.println("是否认证通过!"+isAuthenticated);
	}
	
}
