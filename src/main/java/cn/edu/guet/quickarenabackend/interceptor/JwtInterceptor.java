package cn.edu.guet.quickarenabackend.interceptor;

import cn.edu.guet.quickarenabackend.util.JwtUtil;
import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtInterceptor implements HandlerInterceptor {

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    // 1. 排除不需要认证的接口（如登录、注册等）
    String path = request.getRequestURI();
    if (path.startsWith("/api/auth/")) {
      return true;
    }

    // 2. 获取并校验JWT
    String token = request.getHeader("Authorization");
    if (token != null && token.startsWith("Bearer ")) {
      token = token.substring(7);
      if (jwtUtil.validateToken(token)) {
        Long userId = jwtUtil.getUserIdFromToken(token);
        if (userId != null) {
          // 3. 校验Redis登录态
          String loginFlag = stringRedisTemplate.opsForValue().get(userId.toString());
          if (loginFlag != null && !loginFlag.trim().isEmpty()) {
            // 登录校验通过，可传递用户信息
            request.setAttribute("userId", userId);
            return true;
          }
        }
      }
    }

    // 4. 校验失败，返回401
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.setContentType("application/json;charset=UTF-8");
    Map<String, Object> result = new HashMap<>();
    result.put("code", 401);
    result.put("message", "未授权，请提供有效的Token");
    try {
      response.getWriter().write(JSON.toJSONString(result));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}