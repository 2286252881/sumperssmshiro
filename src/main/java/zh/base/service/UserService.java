package zh.base.service;

import java.util.List;

import zh.base.pojo.po.Tuser;

public interface UserService {
	//查询所有用户
	public List<Tuser> findAlluser(Tuser user,int page,int rows);
	public int findAlluserCount(Tuser user,int page,int rows);
	
	
	//自定义查询
	public List<Tuser> getAlluser();
	//自定义查询
	public List<Tuser> getAlluser2();
	
	//添加用户
	public Tuser addUser(Tuser user);
}
