package cn.edu.guet.quickarenabackend.controller;

import cn.edu.guet.quickarenabackend.dto.UserLoginDto;
import cn.edu.guet.quickarenabackend.entity.Result;
import cn.edu.guet.quickarenabackend.entity.ResultCode;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

  // 用户登录
  @PostMapping("/login")
  public Result<Map<String, Object>> login(@RequestBody UserLoginDto userLoginDto) {
//    String username = loginData.get("username");
//    String password = loginData.get("password");
//    // TODO: 替换为实际数据库校验
//    if ("admin".equals(username) && "123456".equals(password)) {
//      Map<String, Object> data = new HashMap<>();
//      data.put("token", "mock-jwt-token"); // 实际应生成JWT
//      return Result.success(data);
//    } else {
//      return Result.error(ResultCode.USERNAME_OR_PASSWORD_ERROR);
//    }
    return null;
  }

  // 用户注册
  @PostMapping("/register")
  public Result<Void> register(@RequestBody Map<String, String> registerData) {
    String username = registerData.get("username");
    String password = registerData.get("password");
    // TODO: 查重、存库等实际注册逻辑
    if ("admin".equals(username)) {
      return Result.error(ResultCode.USER_ALREADY_EXISTS);
    }
    // 注册成功
    return Result.success();
  }
}