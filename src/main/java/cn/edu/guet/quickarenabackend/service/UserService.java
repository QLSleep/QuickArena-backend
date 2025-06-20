package cn.edu.guet.quickarenabackend.service;

import cn.edu.guet.quickarenabackend.dto.UserInfoDto;

public interface UserService {

  public boolean logout(Long userId);

  public UserInfoDto getUserInfo(Long userId);
}
