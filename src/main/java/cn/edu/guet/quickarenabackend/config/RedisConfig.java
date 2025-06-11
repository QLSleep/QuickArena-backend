package cn.edu.guet.quickarenabackend.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;

@Configuration
public class RedisConfig {

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory);

    // 配置键序列化
    StringRedisSerializer stringSerializer = new StringRedisSerializer();
    template.setKeySerializer(stringSerializer);
    template.setHashKeySerializer(stringSerializer);

    // 配置值序列化（使用FastJson）
    FastJsonRedisSerializer<Object> jsonSerializer = new FastJsonRedisSerializer<>(Object.class);
    template.setValueSerializer(jsonSerializer);
    template.setHashValueSerializer(jsonSerializer);

    template.afterPropertiesSet();
    return template;
  }

  /**
   * FastJson Redis序列化器
   */
  public static class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    private final Class<T> clazz;

    public FastJsonRedisSerializer(Class<T> clazz) {
      super();
      this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
      if (t == null) {
        return new byte[0];
      }
      // 使用FastJson序列化，保留类型信息
      return JSON.toJSONString(t, JSONWriter.Feature.WriteClassName).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
      if (bytes == null || bytes.length <= 0) {
        return null;
      }
      String str = new String(bytes, StandardCharsets.UTF_8);
      // 使用FastJson反序列化，支持自动类型
      return JSON.parseObject(str, clazz, JSONReader.Feature.SupportAutoType);
    }
  }
}