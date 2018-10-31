package net.xdclass.mapper;

import net.xdclass.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chengjiapeng on 2018/9/16.
 * 访问数据库的接口
 */
@Repository
public interface UserMapper {

    @Insert("INSERT INTO user (name, phone, create_time, age) VALUES (#{name}, #{phone}, #{createTime}, #{age} )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(User user);

    @Select("SELECT * from user ")
    @Results({@Result(column = "create_time", property = "createTime")})
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id= #{id} ")
    @Results({@Result(column = "create_time", property = "createTime")})
    User findById(Long id);

    @Update("UPDATE user SET name =#{name} WHERE id =#{id} ")
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{userId}")
    void delete(Long userId);
}
