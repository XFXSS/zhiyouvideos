package com.zhiyou.video.mapper;

import com.zhiyou.video.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findUserByLogin(@Param("email") String email, @Param("password") String password);

    void findUserByRegist(@Param("email") String email, @Param("password") String password);
}
