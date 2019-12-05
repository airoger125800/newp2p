package com.xmg.p2p.base.mapper;

import com.xmg.p2p.base.domain.LoginInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogininfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginInfo record);

    LoginInfo selectByPrimaryKey(Long id);

    List<LoginInfo> selectAll();

    int updateByPrimaryKey(LoginInfo record);

    int selectCountByUsername(@Param(value = "username") String username);
}