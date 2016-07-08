package zh.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zh.base.pojo.po.Tpermission;
import zh.base.pojo.po.TpermissionExample;

public interface TpermissionMapper {
    int countByExample(TpermissionExample example);

    int deleteByExample(TpermissionExample example);

    int insert(Tpermission record);

    int insertSelective(Tpermission record);

    List<Tpermission> selectByExample(TpermissionExample example);

    int updateByExampleSelective(@Param("record") Tpermission record, @Param("example") TpermissionExample example);

    int updateByExample(@Param("record") Tpermission record, @Param("example") TpermissionExample example);
}