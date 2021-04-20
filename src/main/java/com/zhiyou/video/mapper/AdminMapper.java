package com.zhiyou.video.mapper;

import com.zhiyou.video.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    Admin login(@Param("loginName") String loginName , @Param("loginPwd") String loginPwd);
}
