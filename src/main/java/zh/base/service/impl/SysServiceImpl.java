package zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zh.base.dao.mapper.TpermissionMapperCustom;
import zh.base.dao.mapper.TuserMapper;
import zh.base.pojo.po.ActiveUser;
import zh.base.pojo.po.Tpermission;
import zh.base.pojo.po.Trole;
import zh.base.pojo.po.Tuser;
import zh.base.pojo.po.TuserExample;
import zh.base.pojo.vo.Menu;
import zh.base.service.SysService;


/**
 * 
 * <p>Title: SysServiceImpl</p>
 * <p>Description:认证和授权的服务接口 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-23上午11:31:43
 * @version 1.0
 */
public class SysServiceImpl implements SysService {
	
	@Autowired
	private TuserMapper tuserMapper;
	
	@Autowired
	private TpermissionMapperCustom tpermissionMapperCustom;

	public Tuser findSysUserByUserName(String username) throws Exception {
		TuserExample tuserExample=new TuserExample();
		TuserExample.Criteria criteria=tuserExample.createCriteria();
		//根据用户名去查userCode
		criteria.andUsernameEqualTo(username);
		criteria.andLockedEqualTo("1");
		List<Tuser> list = tuserMapper.selectByExample(tuserExample);
		if(list!=null && list.size()==1){
			return list.get(0);
		}	
		return null;
	}
	//根据用户id查询菜单
	public List<Menu> findMenuListByUserId(String userid) throws Exception {
		return tpermissionMapperCustom.findMenuListByUserId(userid);
	}

	//根据用户id查询权限
	public List<Tpermission> findPermissionListByUserId(String userid) throws Exception {
		return tpermissionMapperCustom.findPermissionListByUserId(userid);
	}

	public List<Tpermission> findAllpermissionList() throws Exception {
		
		return tpermissionMapperCustom.findAllpermissionList();
	}
	
	
	//根据用户id获取该用户对应的角色
	public List<Trole> findRoleListByUserId(String userid) throws Exception {
		
		return tpermissionMapperCustom.findRoleListByUserId(userid);
	}

	
}
