package com.crc.oauth2.resource.controller;

import com.crc.oauth2.resource.domain.TbContent;
import com.crc.oauth2.resource.dto.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/11/24 19:30
 **/
@RestController
public class ContentController {

    @GetMapping("/")
    public ResponseResult<TbContent> getContent() {
        TbContent content = new TbContent();
        content.setId(1L);
        content.setContent("测试内容");
        content.setSubTitle("测试主题");
        return new ResponseResult<TbContent>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), content);
    }
}
