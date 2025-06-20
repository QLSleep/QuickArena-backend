package cn.edu.guet.quickarenabackend.util;

import cn.edu.guet.quickarenabackend.config.JwtConfig;
import cn.edu.guet.quickarenabackend.entity.User; // 假设你的User实体在这里
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class  JwtUtil {

  @Resource
  private JwtConfig jwtConfig;
  private Key signingKey;

  @PostConstruct
  public void init() {
    this.signingKey = Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8));
  }

  // 新推荐：直接传User对象
  public String generateToken(User user) {
    Date now = new Date();
    Date expire = new Date(now.getTime() + jwtConfig.getExpiration() * 1000);
    return Jwts.builder()
        .setSubject(String.valueOf(user.getId()))
        .claim("userId", user.getId())
        .claim("username", user.getUserName())
        // .claim("email", user.getEmail()) // 需要时可以加
        .setIssuedAt(now)
        .setExpiration(expire)
        .signWith(signingKey, SignatureAlgorithm.HS256)
        .compact();
  }

  public Claims parseToken(String token) {
    try {
      return Jwts.parserBuilder()
          .setSigningKey(signingKey)
          .build()
          .parseClaimsJws(token)
          .getBody();
    } catch (JwtException e) {
      return null;
    }
  }

  public boolean validateToken(String token) {
    Claims claims = parseToken(token);
    return claims != null && claims.getExpiration().after(new Date());
  }

  public Long getUserIdFromToken(String token) {
    Claims claims = parseToken(token);
    if (claims == null) return null;
    Object idObj = claims.get("userId");
    if (idObj == null) return null;
    if (idObj instanceof Integer) {
      return ((Integer)idObj).longValue();
    }
    if (idObj instanceof Long) {
      return (Long)idObj;
    }
    try {
      return Long.valueOf(String.valueOf(idObj));
    } catch (Exception e) {
      return null;
    }
  }

  public String getUserNameFromToken(String token) {
    Claims claims = parseToken(token);
    return claims == null ? null : (String) claims.get("username");
  }
}