package com.crc.oauth2.server.mapper;

import com.crc.oauth2.server.domain.TbUser;

public interface TbUserMapper{

    TbUser getByUserName(String userName);

}