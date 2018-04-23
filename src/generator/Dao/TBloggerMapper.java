package Dao;

import Entity.TBlogger;
import Entity.TBloggerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBloggerMapper {
    int countByExample(TBloggerExample example);

    int deleteByExample(TBloggerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBlogger record);

    int insertSelective(TBlogger record);

    List<TBlogger> selectByExampleWithBLOBs(TBloggerExample example);

    List<TBlogger> selectByExample(TBloggerExample example);

    TBlogger selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBlogger record, @Param("example") TBloggerExample example);

    int updateByExampleWithBLOBs(@Param("record") TBlogger record, @Param("example") TBloggerExample example);

    int updateByExample(@Param("record") TBlogger record, @Param("example") TBloggerExample example);

    int updateByPrimaryKeySelective(TBlogger record);

    int updateByPrimaryKeyWithBLOBs(TBlogger record);

    int updateByPrimaryKey(TBlogger record);
}