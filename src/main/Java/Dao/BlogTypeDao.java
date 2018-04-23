package Dao;


import Entity.BlogType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 博客类别dao
 */

@Repository
public interface BlogTypeDao {
    Integer addBlogType(BlogType blogType);

    Integer deleteBlogType(Integer id);

    /**
     * 更新博客类别信息
     * @param blogType
     * @return
     */
    Integer updateBlogType(BlogType blogType);

    /**
     * 根据id查询博客类别信息
     * @param id
     * @return
     */
    BlogType getById(Integer id);

    /**
     * 分页查询博客类别信息
     * @param start
     * @param end
     * @return
     */

    List<BlogType> listByPage(@Param("start") Integer start, @Param("end") Integer end);

    /**
     * 查询总记录数
     */

    Long getTotal();

}
