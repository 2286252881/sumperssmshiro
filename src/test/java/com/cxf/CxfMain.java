package com.cxf;


import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import zh.base.pojo.po.Tpermission;
import zh.base.utils.JsonUtil;
import zh.base.ws.soap_cxf.HelloService;

public class CxfMain {
	public static void main(String[] args) {
		
		JaxWsProxyFactoryBean factory=new JaxWsProxyFactoryBean();
		
		
		factory.setAddress("http://localhost:8089/superssm/ws/soap/hello");
		factory.setServiceClass(HelloService.class);
		HelloService helloService=factory.create(HelloService.class);
		List<Tpermission> permissions=helloService.say("admin");
		System.out.println(JsonUtil.toJson(permissions));
	}
}
