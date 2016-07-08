package zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zh.base.dao.mapper.TuserMapper;
import zh.base.pojo.po.Tuser;
import zh.base.pojo.po.TuserExample;
import zh.base.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired private TuserMapper tuserMapper;
	
	public int findAlluserCount(Tuser user, int page, int rows) {
		return tuserMapper.findAlluserCount(user, page, rows);
	}
	public List<Tuser> findAlluser(Tuser user,int page,int rows) {
		return tuserMapper.findAlluser(user, page, rows);
	}

	public List<Tuser> getAlluser() {
		
		return tuserMapper.getAlluser();
	}

	public List<Tuser> getAlluser2() {
		
		return tuserMapper.getAlluser2();
	}

	public Tuser addUser(Tuser user) {
		TuserExample tuserExample=new TuserExample();
		TuserExample.Criteria criteria=tuserExample.createCriteria();
		if(user.getUsername()!=null){
			criteria.andUsernameEqualTo(user.getUsername());
		}
		List<Tuser> list=tuserMapper.selectByExample(tuserExample);
		if(list.size()>0){
			return null;
		}else{
			tuserMapper.insert(user);
			return user;
		}
	}
}
