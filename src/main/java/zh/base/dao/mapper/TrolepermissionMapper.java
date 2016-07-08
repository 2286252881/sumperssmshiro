package zh.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zh.base.pojo.po.Trolepermission;
import zh.base.pojo.po.TrolepermissionExample;

public interface TrolepermissionMapper {
    int countByExample(TrolepermissionExample example);

    int deleteByExample(TrolepermissionExample example);

    int insert(Trolepermission record);

    int insertSelective(Trolepermission record);

    List<Trolepermission> selectByExample(TrolepermissionExample example);

    int updateByExampleSelective(@Param("record") Trolepermission record, @Param("example") TrolepermissionExample example);

    int updateByExample(@Param("record") Trolepermission record, @Param("example") TrolepermissionExample example);
}