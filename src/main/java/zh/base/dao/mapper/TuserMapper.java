package zh.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zh.base.pojo.po.Tuser;
import zh.base.pojo.po.TuserExample;

public interface TuserMapper {
    int countByExample(TuserExample example);

    int deleteByExample(TuserExample example);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    List<Tuser> selectByExample(TuserExample example);

    int updateByExampleSelective(@Param("record") Tuser record, @Param("example") TuserExample example);

    int updateByExample(@Param("record") Tuser record, @Param("example") TuserExample example);
    
    
    public List<Tuser> findAlluser(@Param("user")Tuser user, @Param("page")int page, @Param("rows")int rows);
    public int  findAlluserCount(@Param("user")Tuser user, @Param("page")int page, @Param("rows")int rows);
    
  //自定义查询
  	public List<Tuser> getAlluser();
  //自定义查询
  	public List<Tuser> getAlluser2();
  	
 
    
}