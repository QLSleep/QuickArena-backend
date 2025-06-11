package cn.edu.guet.quickarenabackend.entity;

/**
 * 通用API响应结构
 */
public class Result<T> {
  private int code;
  private String message;
  private T data;

  public Result() {}

  public Result(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  // 通过 ResultCode 枚举快速构造
  public Result(ResultCode resultCode, T data) {
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
    this.data = data;
  }

  public Result(ResultCode resultCode) {
    this(resultCode, null);
  }

  // 工厂方法 - 成功
  public static <T> Result<T> success() {
    return new Result<>(ResultCode.SUCCESS);
  }

  public static <T> Result<T> success(T data) {
    return new Result<>(ResultCode.SUCCESS, data);
  }

  public static <T> Result<T> success(String message, T data) {
    return new Result<>(ResultCode.SUCCESS.getCode(), message, data);
  }

  // 工厂方法 - 失败
  public static <T> Result<T> error(ResultCode resultCode) {
    return new Result<>(resultCode);
  }

  public static <T> Result<T> error(ResultCode resultCode, T data) {
    return new Result<>(resultCode, data);
  }

  public static <T> Result<T> error(int code, String message) {
    return new Result<>(code, message, null);
  }

  // Getter & Setter
  public int getCode() {
    return code;
  }
  public void setCode(int code) {
    this.code = code;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }
}