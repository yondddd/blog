package com.lm.blog.server.gw.user;

import com.alibaba.fastjson2.JSON;
import com.lm.blog.response.RemoteResponse;
import com.lm.blog.server.gw.user.controller.UserController;
import com.lm.blog.server.gw.user.request.EmailRequest;
import com.lm.blog.server.gw.user.request.MobileRequest;
import com.lm.blog.server.gw.user.response.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Administrator
 * @Description 用户测试
 * @Date 2023/1/20
 */
@SpringBootTest
public class UserControllerTest {

    @Resource
    private UserController userController;

    @Test
    public void getByEmailTest() {
        EmailRequest request = new EmailRequest();
        request.setEmail("123456@qq.com");
        RemoteResponse<List<UserVO>> response = userController.getByEmail(request);
        System.out.println(response);
        request.setEmail("133223@qq.com");
        RemoteResponse<List<UserVO>> responseOne = userController.getByEmail(request);
        System.out.println(responseOne);
        request.setEmail("13888@qq.com");
        RemoteResponse<List<UserVO>> responseTwo = userController.getByEmail(request);
        System.out.println(responseTwo);
    }

    @Test
    public void getByMobileTest() {
        MobileRequest request = new MobileRequest();
        request.setMobile("133223536351");
        RemoteResponse<UserVO> response = userController.getByMobile(request);
        System.out.println(response);
    }

    @Test
    public void listAllTest() {
        RemoteResponse<List<UserVO>> response = userController.list();
        System.out.println(response);
        for (UserVO data : response.getData()) {
            System.out.println(data);
        }
    }
}
