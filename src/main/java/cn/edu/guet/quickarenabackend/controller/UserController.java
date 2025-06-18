package cn.edu.guet.quickarenabackend.controller;

import cn.edu.guet.quickarenabackend.entity.Result;
import cn.edu.guet.quickarenabackend.entity.ResultCode;
import cn.edu.guet.quickarenabackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private AuthService authService;

  // 退出登录
  @PostMapping("/logout")
    public Result<Void> logout(HttpServletRequest request) {
    Object userIdObj = request.getAttribute("userId");
    if (userIdObj == null) {
      return Result.error(ResultCode.UNAUTHORIZED, null);
    }
    Long userId;
    try {
      userId = Long.valueOf(userIdObj.toString());
    } catch (Exception e) {
      return Result.error(ResultCode.PARAM_ERROR, null);
    }
    boolean success = authService.logout(userId);
    if (success) {
      return Result.success();
    } else {
      return Result.error(ResultCode.FAIL, null);
    }
  }

  @GetMapping("/testRsc")
  public Result<String> testRsc(HttpServletRequest request) {
    return Result.success("这是测试信息");
  }
}