package cn.edu.guet.quickarenabackend.controller;

import cn.edu.guet.quickarenabackend.dto.UserLoginDto;
import cn.edu.guet.quickarenabackend.dto.UserRegisterDto;
import cn.edu.guet.quickarenabackend.entity.Result;
import cn.edu.guet.quickarenabackend.entity.ResultCode;
import cn.edu.guet.quickarenabackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  // 用户登录
  @PostMapping("/login")
  public Result<Map<String, Object>> login(@RequestBody UserLoginDto userLoginDto) {
    try {
      String token = authService.login(userLoginDto);
      Map<String, Object> data = new HashMap<>();
      data.put("token", token);
      return Result.success(data);
    } catch (IllegalArgumentException e) {
      String msg = e.getMessage();
      if ("用户名或密码不能为空".equals(msg)) {
        return Result.error(ResultCode.PARAM_ERROR, null);
      } else if ("用户名或密码错误".equals(msg)) {
        return Result.error(ResultCode.USERNAME_OR_PASSWORD_ERROR, null);
      } else {
        return Result.error(ResultCode.FAIL, null);
      }
    } catch (IllegalStateException e) {
      // 用户已登录
      return Result.error(ResultCode.USER_ALREADY_LOGGED_IN, null);
    } catch (Exception e) {
      // 其他未预见异常
      return Result.error(ResultCode.SERVER_ERROR, null);
    }
  }

  // 用户注册
  @PostMapping("/register")
  public Result<Void> register(@RequestBody UserRegisterDto userRegisterDto) {
    try {
      boolean success = authService.register(userRegisterDto);
      if (success) {
        return Result.success(); // 注册成功
      } else {
        // 理论上不会到这里，因为service已抛异常，但为了兜底
        return Result.error(ResultCode.FAIL, null);
      }
    } catch (IllegalArgumentException e) {
      String msg = e.getMessage();
      if ("用户名或密码不能为空".equals(msg)) {
        return Result.error(ResultCode.PARAM_ERROR, null);
      } else if ("用户名已存在".equals(msg)) {
        return Result.error(ResultCode.USER_ALREADY_EXISTS, null);
      } else {
        return Result.error(ResultCode.FAIL, null);
      }
    } catch (Exception e) {
      // 其它未预见异常
      return Result.error(ResultCode.SERVER_ERROR, null);
    }
  }
}