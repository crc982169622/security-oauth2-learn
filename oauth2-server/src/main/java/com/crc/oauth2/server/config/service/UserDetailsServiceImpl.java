package com.crc.oauth2.server.config.service;

import com.crc.oauth2.server.domain.TbPermission;
import com.crc.oauth2.server.domain.TbUser;
import com.crc.oauth2.server.service.TbPermissionService;
import com.crc.oauth2.server.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/11/24 17:09
 * 自定义用户认证和授权
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService userService;

    @Autowired
    private TbPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = userService.getByUsername(s);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (tbUser != null && tbUser.getId() != null) {
            List<TbPermission> permissions = permissionService.selectByUserId(tbUser.getId());
            permissions.forEach(tbPermission -> {
                if (tbPermission != null && tbPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }

            });
        }
        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}
