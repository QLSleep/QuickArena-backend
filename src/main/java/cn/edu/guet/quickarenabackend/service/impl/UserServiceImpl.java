package cn.edu.guet.quickarenabackend.service.impl;

import cn.edu.guet.quickarenabackend.dto.UserInfoDto;
import cn.edu.guet.quickarenabackend.dto.UserRegisterDto;
import cn.edu.guet.quickarenabackend.entity.User;
import cn.edu.guet.quickarenabackend.mapper.UserMapper;
import cn.edu.guet.quickarenabackend.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private StringRedisTemplate stringRedisTemplate; // 只操作字符串的模板

  @Override
  public boolean logout(Long userId) {

    User user = userMapper.selectById(userId);
    if (user == null) {
      //TODO
      return false;
    }

    stringRedisTemplate.delete(userId.toString());

    return true;
  }

  @Override
  public UserInfoDto getUserInfo(Long userId) {
    UserInfoDto userInfoDto = new UserInfoDto();
    User user = userMapper.selectById(userId);
    if (user != null) {
      userInfoDto.setId(userId);
      userInfoDto.setUserName(user.getUserName());
      userInfoDto.setCreateTime(user.getCreateTime());
    }else {
      return null;
    }
    return userInfoDto;
  }
}
