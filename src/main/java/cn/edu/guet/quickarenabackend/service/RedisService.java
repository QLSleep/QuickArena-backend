package cn.edu.guet.quickarenabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  // 设置普通缓存
  public boolean set(String key, Object value) {
    try {
      redisTemplate.opsForValue().set(key, value);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // 设置缓存并带过期时间（秒）
  public boolean set(String key, Object value, long timeout) {
    try {
      if (timeout > 0) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
      } else {
        set(key, value);
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // 获取缓存
  public Object get(String key) {
    return key == null ? null : redisTemplate.opsForValue().get(key);
  }

  // 删除缓存
  public Boolean del(String key) {
    return key != null && redisTemplate.delete(key);
  }

  // 判断缓存是否存在
  public Boolean hasKey(String key) {
    try {
      return redisTemplate.hasKey(key);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // 设置过期时间
  public Boolean expire(String key, long timeout) {
    return timeout > 0 && redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
  }
}