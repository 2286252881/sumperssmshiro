package zh.base.service;

import java.util.List;

import zh.base.pojo.po.ActiveUser;
import zh.base.pojo.po.Tpermission;
import zh.base.pojo.po.Trole;
import zh.base.pojo.po.Tuser;
import zh.base.pojo.vo.Menu;


/**
 * 
 * <p>Title: SysService</p>
 * <p>Description: 认证授权服务接口</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-23上午11:29:48
 * @version 1.0
 */
public interface SysService {
	
	//根据用户账号查询用户信息
	public Tuser findSysUserByUserName(String username)throws Exception;
	
	//根据用户id查询权限范围的菜单
	public List<Menu> findMenuListByUserId(String userid) throws Exception;
	
	//根据用户id查询权限范围的url
	public List<Tpermission> findPermissionListByUserId(String userid) throws Exception;
	
	//根据用户id查询出所有角色
	public List<Trole> findRoleListByUserId(String userid)throws Exception;
	
}
