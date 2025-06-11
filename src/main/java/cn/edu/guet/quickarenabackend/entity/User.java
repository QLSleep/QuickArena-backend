package cn.edu.guet.quickarenabackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("user")
public class User {
  @TableId(type = IdType.AUTO)
  private Long id;

  @TableField("username")
  private String userName;

  @TableField("password")
  private String password;

  @TableField("avatar")
  private String avatar;

  @TableField("create_time")
  private LocalDateTime createTime;

  @TableField("update_time")
  private LocalDateTime updateTime;

  public User(Long id, String userName, String password, String avatar, LocalDateTime createTime, LocalDateTime updateTime) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.avatar = avatar;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  public User() {
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", avatar='" + avatar + '\'' +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        '}';
  }
}