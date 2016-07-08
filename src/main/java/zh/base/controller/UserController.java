package zh.base.controller;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zh.base.pojo.po.ActiveUser;
import zh.base.pojo.po.Trole;
import zh.base.pojo.po.Tuser;
import zh.base.service.SysService;
import zh.base.service.UserService;
import zh.base.utils.Datagrid;
import zh.base.utils.PageQuery;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired private UserService userService;
	
	@Autowired private SysService sysService;
	
	/*
	 * 到达用户页面
	 */
	@RequestMapping("/user")
	public String queryuser(){
		return "/base/user/user";
	}
	/*
	 * 加载用户数据
	 */
	@RequestMapping("/queryData")
	public @ResponseBody Datagrid<Tuser> queryuserData(Tuser user,int page,int rows){
		PageQuery pageQuery=new PageQuery();
		int total=userService.findAlluserCount(user, page, rows);
		pageQuery.setPageParams(total, rows, page);
		if(page>1){
			pageQuery.setPageQuery_start(pageQuery.getPageQuery_start()+1);
		}
		List<Tuser> list=userService.findAlluser(user,pageQuery.getPageQuery_start(),pageQuery.getPageQuery_end());
		Datagrid<Tuser> dg=new Datagrid<Tuser>();
		dg.setRows(list);
		dg.setTotal((long) total);
		return dg;
	}
	@RequestMapping(value="/update",method={RequestMethod.GET})
	@RequiresPermissions("user:update")
	public String updateUser(){
		return "/base/user/edit";
	}
	
	//达到用户添加页面
	@RequestMapping("/toAddUser")
	public String toAddUser(){
		return "/base/user/edit";
	}
	//添加新用户
	@RequestMapping("/doAddUser")
	public @ResponseBody Tuser doAddUser(Tuser user){
		user.setId(UUID.randomUUID().toString());
		user.setLocked("1");
		user.setSalt(UUID.randomUUID().toString().substring(0, 5));
		SimpleHash simpleHash=new SimpleHash("md5", user.getPwd(), user.getSalt(), 1);
		user.setPwd(simpleHash.toString());
		user=userService.addUser(user);
		return user;
	}
	
	/*
	 * 到达角色管理页面
	 */
	@RequestMapping("/role")
	public String queryRole(){
		return "/base/user/role";
	}
	
	/**
	 * 加载角色数据
	 */
	@RequestMapping("/queryRoleData")
	public @ResponseBody Datagrid<Trole> queryRoleData(){
		Subject subject=SecurityUtils.getSubject();
		//取出身份信息
		ActiveUser activeUser=(ActiveUser) subject.getPrincipal();
		Datagrid<Trole> dg=new Datagrid<Trole>();
		try {
			List<Trole> list=sysService.findRoleListByUserId(activeUser.getUserid());
			dg.setRows(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dg;
	}
	
}
