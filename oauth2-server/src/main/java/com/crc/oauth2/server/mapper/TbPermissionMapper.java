package com.crc.oauth2.server.mapper;

import com.crc.oauth2.server.domain.TbPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TbPermissionMapper{

    List<TbPermission> selectByUserId(@Param("userId") Long userId);

}