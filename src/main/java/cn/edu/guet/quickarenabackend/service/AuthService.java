package cn.edu.guet.quickarenabackend.service;

import cn.edu.guet.quickarenabackend.dto.UserLoginDto;
import cn.edu.guet.quickarenabackend.dto.UserRegisterDto;

public interface AuthService {

  public String login(UserLoginDto userLoginDto);

//  public boolean logout(Long userId);

  public boolean register(UserRegisterDto userRegisterDto);

}
