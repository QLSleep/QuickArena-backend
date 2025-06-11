package cn.edu.guet.quickarenabackend.dto;


public class UserRegisterDto {

  private String userName;

  private String password;

  public UserRegisterDto(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public UserRegisterDto() {
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
    return "UserRegisterDto{" +
        "userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
