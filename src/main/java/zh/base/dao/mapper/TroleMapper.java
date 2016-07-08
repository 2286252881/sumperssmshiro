package zh.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zh.base.pojo.po.Trole;
import zh.base.pojo.po.TroleExample;

public interface TroleMapper {
    int countByExample(TroleExample example);

    int deleteByExample(TroleExample example);

    int insert(Trole record);

    int insertSelective(Trole record);

    List<Trole> selectByExample(TroleExample example);

    int updateByExampleSelective(@Param("record") Trole record, @Param("example") TroleExample example);

    int updateByExample(@Param("record") Trole record, @Param("example") TroleExample example);
}