package cn.edu.guet.quickarenabackend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
  private String secret;
  private long expiration; // 秒

  public String getSecret() { return secret; }
  public void setSecret(String secret) { this.secret = secret; }

  public long getExpiration() { return expiration; }
  public void setExpiration(long expiration) { this.expiration = expiration; }
}