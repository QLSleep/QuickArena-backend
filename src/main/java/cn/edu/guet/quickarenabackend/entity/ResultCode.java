package cn.edu.guet.quickarenabackend.entity;

/**
 * 统一业务状态码
 */
public enum ResultCode {
  SUCCESS(0, "操作成功"),
  FAIL(1, "操作失败"),
  UNAUTHORIZED(401, "未认证或token已失效"),
  FORBIDDEN(403, "没有权限"),
  NOT_FOUND(404, "资源不存在"),
  SERVER_ERROR(500, "服务器内部错误"),
  USERNAME_OR_PASSWORD_ERROR(1001, "用户名或密码错误"),
  USER_ALREADY_EXISTS(1002, "用户已存在"),
  PARAM_ERROR(1003, "参数错误");
  // ...可以继续扩展

  private final int code;
  private final String message;

  ResultCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }
  public String getMessage() {
    return message;
  }
}