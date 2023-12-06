package com.codegym.demo.security.utils;


import com.example.demologin.entity.Account;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil  {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final long EXPIrE_DURATION = 24 * 60 * 60 * 1000; //24h;
    @Value("${app.jwt.secret}")
    private String secretKey;

//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return doGenerateToken(claims, userDetails.getUsername());
//    }

//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIrE_DURATION * 1000))
//                .signWith(SignatureAlgorithm.HS512, secretKey)
//                .compact();
//    }

//    public String generateToken(Account account) {
//       return  Jwts.builder()
//                    .setSubject(account.getUsername() + "," +account.getPassword())
//                    .setIssuer("Code Java")
//                    .setIssuedAt(new Date(System.currentTimeMillis()))
//                    .setExpiration(new Date(System.currentTimeMillis() +EXPIrE_DURATION))
//                    .signWith(SignatureAlgorithm.HS512, secretKey)
//                    .compact();
//    }

    public String generateToken(Account account) {
        return  Jwts.builder()
                .setSubject(account.getUsername() + "," +account.getPassword())
                .claim("roles", account.getRoles().toString())
                .setIssuer("Code Java")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +EXPIrE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex);
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or has only whitespace", ex);
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is valid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed", ex);
        }
        return false;
    }

    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    public Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

}

