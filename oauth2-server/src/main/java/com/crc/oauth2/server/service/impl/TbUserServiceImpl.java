package com.crc.oauth2.server.service.impl;

import com.crc.oauth2.server.domain.TbUser;
import com.crc.oauth2.server.mapper.TbUserMapper;
import com.crc.oauth2.server.service.TbUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
        return tbUserMapper.getByUserName(username);
    }
}
