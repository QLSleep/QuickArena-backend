package cn.edu.guet.quickarenabackend.dto;


public class UserLoginDto {

  private String userName;

  private String password;

  public UserLoginDto(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public UserLoginDto() {
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

  @Override
  public String toString() {
    return "UserLoginDto{" +
        "userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
