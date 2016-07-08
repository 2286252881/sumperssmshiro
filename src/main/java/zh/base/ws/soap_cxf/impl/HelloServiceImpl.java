package zh.base.ws.soap_cxf.impl;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zh.base.pojo.po.Tpermission;
import zh.base.service.SysService;
import zh.base.utils.JsonUtil;
import zh.base.ws.soap_cxf.HelloService;

@WebService
@Component
public class HelloServiceImpl implements HelloService {

	@Autowired
	private SysService sysService;

	public List<Tpermission> say(String userName) {
		/*List<Tpermission> permissions = null;
		try {
			permissions = sysService.findMenuListByUserId(userName);
			System.out.println("1:"+JsonUtil.toJson(permissions));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return permissions;*/
		
		//从数据库查询不通过，改为手动测试
		List<Tpermission> ps=new ArrayList<Tpermission>();
		Tpermission p1=new Tpermission();
		p1.setId("001");
		p1.setName("添加权限");
		Tpermission p2=new Tpermission();
		p2.setId("002");
		p2.setName("编辑权限");
		ps.add(p1);
		ps.add(p2);
		return ps;
	}
	

}
