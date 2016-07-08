package zh.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zh.base.pojo.po.Tuserrole;
import zh.base.pojo.po.TuserroleExample;

public interface TuserroleMapper {
    int countByExample(TuserroleExample example);

    int deleteByExample(TuserroleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Tuserrole record);

    int insertSelective(Tuserrole record);

    List<Tuserrole> selectByExample(TuserroleExample example);

    Tuserrole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Tuserrole record, @Param("example") TuserroleExample example);

    int updateByExample(@Param("record") Tuserrole record, @Param("example") TuserroleExample example);

    int updateByPrimaryKeySelective(Tuserrole record);

    int updateByPrimaryKey(Tuserrole record);
}