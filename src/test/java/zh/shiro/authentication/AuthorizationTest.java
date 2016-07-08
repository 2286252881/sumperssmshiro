package zh.shiro.authentication;



import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthorizationTest {
	
	@Test
	public void testAuthorization(){
		Factory<SecurityManager> factory= new IniSecurityManagerFactory("shiro-permission.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "123");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		//是否认证通过
		boolean  isAuthenticated=subject.isAuthenticated();
		System.out.println("是否认证通过!"+isAuthenticated);
		//认证通过进行角色授权
		//单个角色
		boolean hasrole=subject.hasRole("role1");
		//多个角色
		boolean[] hasroles=subject.hasRoles(Arrays.asList("role1","role2"));
		System.out.println("(单个角色判断)用户是否有该角色："+hasrole);
		System.out.println("(多个角色判断)用户是否有该角色：");
		for (boolean b : hasroles) {
			System.out.print("用户是否有该角色："+b+"\t");
		}
		System.out.println();
		//基于资源授权
		boolean haspermitted=subject.isPermitted("user:create");
		boolean haspermittedALL=subject.isPermittedAll("user:create","user:delete","user:query");
		System.out.println("(单个资源判断)用户是否有该资源:"+haspermitted);
		System.out.println("(多个资源判断)用户是否有该角色："+haspermittedALL);
		System.out.println();
		
		//使用check方法进行授权，如果授权不通过会抛出异常
		//subject.checkRole("role4");
		subject.checkPermission("user:import");
		//退出操作
		subject.logout();
		
		//是否认证通过
		isAuthenticated=subject.isAuthenticated();
		System.out.println("是否认证通过!"+isAuthenticated);
	}
	@Test
	public void testAuthorizationCustomRealm(){
		Factory<SecurityManager> factory= new IniSecurityManagerFactory("shiro-realm.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "111112");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		//是否认证通过
		boolean  isAuthenticated=subject.isAuthenticated();
		System.out.println("是否认证通过!"+isAuthenticated);
		//认证通过进行角色授权
		//基于资源授权
		boolean haspermitted=subject.isPermitted("user:create");
		boolean haspermittedALL=subject.isPermittedAll("user:create","items:add","user:query");
		System.out.println("(单个资源判断)用户是否有该资源:"+haspermitted);
		System.out.println("(多个资源判断)用户是否有该角色："+haspermittedALL);
		System.out.println();
		
		//使用check方法进行授权，如果授权不通过会抛出异常
		//subject.checkRole("role4");
		//subject.checkPermission("user:import");
		//退出操作
		subject.logout();
		
		//是否认证通过
		isAuthenticated=subject.isAuthenticated();
		System.out.println("是否认证通过!"+isAuthenticated);
	}
}
