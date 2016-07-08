package zh.base.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zh.base.pojo.po.ActiveUser;

@Controller
public class FirstController {
	@RequestMapping("/first")
	public String first( Model model){
		Subject subject=SecurityUtils.getSubject();
		//取出身份信息
		ActiveUser activeUser=(ActiveUser) subject.getPrincipal();
		model.addAttribute("activeUser", activeUser);
		return "/base/first";
	}
}
