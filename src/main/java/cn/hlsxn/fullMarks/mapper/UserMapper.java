package cn.hlsxn.fullMarks.mapper;

import cn.hlsxn.fullMarks.pojo.UserPojo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

    @Select("select * from users")
    public List<UserPojo> findAll();

    @Select("select uid,username,ustatus,upassword,unumber,uemail,uname,uface,ugrade,user_houseId from users " +
            " where username = #{user} And upassword = #{password}")
    UserPojo login(@Param("user") String user, @Param("password") String password);

    @Select("select username from users where username = #{username}")
    String findByUserName(String username);

    @Insert("insert into users(username,upassword,unumber,uemail,uuid,uname,uface) values(" +
            "#{user.username},#{user.upassword},#{user.unumber},#{user.uemail},#{user.uuid},#{user.uname},#{user.uface})")
    void insert(@Param("user") UserPojo user);
}
