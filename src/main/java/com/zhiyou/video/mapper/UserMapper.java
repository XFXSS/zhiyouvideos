package com.zhiyou.video.mapper;

import com.zhiyou.video.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findUserByLogin(@Param("email") String email, @Param("password") String password);

    void findUserByRegist(@Param("email") String email, @Param("password") String password);

    User findUserByprofile(String nick_name);

    void findUserByprofiletwo(User user);

    User findUserByavatar(String nick_name);

    void findUserByavatartwo(@Param("head_url")String head_url,@Param("nick_name")String nick_name);

    User findUserBypassword(String nick_name);

    void findUserBypasswords(@Param("password")String password,@Param("newPasswords") String newPasswords);
}
