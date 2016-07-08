package jurisdiction;

import java.util.List;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zh.base.pojo.po.Tuser;
import zh.base.service.UserService;
import zh.base.utils.JsonUtil;

public class Test {
	private ApplicationContext ac;
	private UserService userService;
	@Before
	public void testBefor(){
		ac=new ClassPathXmlApplicationContext(
				new String[]{"spring/applicationContext-base-dao.xml","spring/applicationContext-base-service.xml"
				,"spring/applicationContext.xml"});
		userService=(UserService) ac.getBean("userService");
	}
	@org.junit.Test
	public void test(){
		List<Tuser> us=userService.getAlluser2();
		System.out.println(JsonUtil.toJson(us));
	}
}
