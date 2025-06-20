package cn.edu.guet.quickarenabackend.service.impl;

import cn.edu.guet.quickarenabackend.dto.UserLoginDto;
import cn.edu.guet.quickarenabackend.dto.UserRegisterDto;
import cn.edu.guet.quickarenabackend.entity.User;
import cn.edu.guet.quickarenabackend.mapper.UserMapper;
import cn.edu.guet.quickarenabackend.service.AuthService;
import cn.edu.guet.quickarenabackend.util.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private StringRedisTemplate stringRedisTemplate; // 只操作字符串的模板


  @Override
  public String login(UserLoginDto userLoginDto) {

    // 判断空输入
    if (userLoginDto == null
        || userLoginDto.getUserName() == null
        || userLoginDto.getUserName().trim().isEmpty()
        || userLoginDto.getPassword() == null
        || userLoginDto.getPassword().trim().isEmpty()) {
      //TODO
      throw new IllegalArgumentException("用户名或密码不能为空");
    }

    // 查询用户
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("username", userLoginDto.getUserName());
    queryWrapper.eq("password", userLoginDto.getPassword()); // 生产环境建议密码加密比对

    User user = userMapper.selectOne(queryWrapper);
    if (user == null) {
      //TODO
      throw new IllegalArgumentException("用户名或密码错误");
    }

    // 在redis中查询用户是否已经登录
    String loginFlag = stringRedisTemplate.opsForValue().get(user.getId().toString());
    if (loginFlag != null && !loginFlag.trim().isEmpty()) {
      //TODO
      throw new IllegalStateException("用户已登录");
    }

    // redis中缓存登录成功的用户
    stringRedisTemplate.opsForValue().set(user.getId().toString(), "1");

    return jwtUtil.generateToken(user);
  }

//  @Override
//  public boolean logout(Long userId) {
//
//    User user = userMapper.selectById(userId);
//    if (user == null) {
//      //TODO
//      return false;
//    }
//
//    stringRedisTemplate.delete(userId.toString());
//
//    return true;
//  }


  @Override
  public boolean register(UserRegisterDto userRegisterDto) {
    // 1. 参数校验
    if (userRegisterDto == null
        || userRegisterDto.getUserName() == null
        || userRegisterDto.getUserName().trim().isEmpty()
        || userRegisterDto.getPassword() == null
        || userRegisterDto.getPassword().trim().isEmpty()) {
      //TODO
      throw new IllegalArgumentException("用户名或密码不能为空");
    }
    // 2. 判断用户名是否已存在
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("username", userRegisterDto.getUserName());
    User existingUser = userMapper.selectOne(queryWrapper);
    if (existingUser != null) {
      //TODO
      throw new IllegalArgumentException("用户名已存在");
    }
    // 3. 保存新用户（明文密码，仅用于演示）
    User user = new User();
    user.setUserName(userRegisterDto.getUserName());
    user.setPassword(userRegisterDto.getPassword());
    int rows = userMapper.insert(user);

    // 4. 返回注册结果
    return rows > 0;
  }

}
