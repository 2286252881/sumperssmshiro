package zh.base.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zh.base.pojo.po.Tpermission;
import zh.base.pojo.po.Trole;
import zh.base.pojo.vo.Menu;

public interface TpermissionMapperCustom {
	//根据用户id查询菜单
	public List<Menu> findMenuListByUserId(String userid)throws Exception;
	//根据用户id查询权限url
	public List<Tpermission> findPermissionListByUserId(String userid)throws Exception;
	
	//根据用户id查询出所有角色
	public List<Trole> findRoleListByUserId(@Param("id")String userid)throws Exception;
	
	
	
	
	//查询所有权限
	public List<Tpermission> findAllpermissionList()throws Exception;
}
