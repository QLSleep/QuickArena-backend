package cn.edu.guet.quickarenabackend.dto;

import java.time.LocalDateTime;

public class UserInfoDto {
  private Long id;
  private String userName;
  private LocalDateTime createTime;

  public UserInfoDto(Long id, String userName, LocalDateTime createTime) {
    this.id = id;
    this.userName = userName;
    this.createTime = createTime;
  }

  public UserInfoDto() {
  }

  @Override
  public String toString() {
    return "UserInfoDto{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
}
