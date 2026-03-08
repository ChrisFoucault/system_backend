package org.bussiness.system_backend.constants;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    /**
     * 建议放到 application.yml
     */
    private static final String SECRET = "my-secret-key-my-secret-key-my-secret-key-my-secret-key";

    /**
     * token过期时间 (1小时)
     */
    private static final long EXPIRATION = 1000 * 60 * 60;

    /**
     * 签名key
     */
    private static final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    /**
     * 生成Token
     */
    public static String generateToken(String username) {
        return generateToken(username, null);
    }

    /**
     * 生成Token（带自定义Claim）
     */
    public static String generateToken(String username, Map<String, Object> claims) {
        JwtBuilder builder = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256);
        if (claims != null) {
            builder.addClaims(claims);
        }
        return builder.compact();
    }

    /**
     * 解析Token
     */
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private static boolean isJwtFormat(String token) {
        return token != null && token.split("\\.").length == 3;
    }

    /**
     * 兼容旧格式 token: Base64("id:username:...")
     */
    private static String getLegacyUsername(String token) {
        try {
            String decoded = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
            String[] parts = decoded.split(":");
            if (parts.length >= 2 && !parts[1].isBlank()) {
                return parts[1];
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     * 获取用户名
     */
    public static String getUsername(String token) {
        if (isJwtFormat(token)) {
            return parseToken(token).getSubject();
        }
        String legacyUsername = getLegacyUsername(token);
        if (legacyUsername == null) {
            throw new IllegalArgumentException("Invalid token format");
        }
        return legacyUsername;
    }

    /**
     * 获取过期时间
     */
    public static Date getExpiration(String token) {
        return parseToken(token).getExpiration();
    }

    /**
     * 是否过期
     */
    public static boolean isExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    /**
     * 校验token
     */
    public static boolean validateToken(String token, String username) {
        if (isJwtFormat(token)) {
            return username.equals(getUsername(token)) && !isExpired(token);
        }
        String legacyUsername = getLegacyUsername(token);
        return legacyUsername != null && username.equals(legacyUsername);
    }

    /**
     * 校验token是否合法
     */
    public static boolean isTokenValid(String token) {
        if (!isJwtFormat(token)) {
            return getLegacyUsername(token) != null;
        }
        try {
            parseToken(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("JWT expired");
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT unsupported");
        } catch (MalformedJwtException e) {
            System.out.println("JWT malformed");
        } catch (SecurityException e) {
            System.out.println("JWT signature invalid");
        } catch (IllegalArgumentException e) {
            System.out.println("JWT empty");
        }
        return false;
    }

}