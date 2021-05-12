package edu.miu.ecommerce.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JwtUtil {

    private String secret;
    private int jwtExpirationInMs;

    @Value("${jwt.secret}")
    public void setSecret(String secret){
        this.secret = secret;
    }

    @Value("${jwt.jwtExpirationInMs}")
    public void setJwtExpirationInMs(int jwtExpirationInMs) {
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
        if(roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            claims.put("isAdmin", true);
        }
        if(roles.contains(new SimpleGrantedAuthority("ROLE_SELLER"))){
            claims.put("isSeller", true);
        }
        if(roles.contains(new SimpleGrantedAuthority("ROLE_BUYER"))){
            claims.put("isBuyer", true);
        }
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String authToken){
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);

        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex){
            throw new BadCredentialsException("INVALID CREDENTIALS", ex);
        } catch (ExpiredJwtException ex){
//            TODO
//            throw new Exception(header, claims, "Token has expired", ex);
        }
        return true;
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public List<SimpleGrantedAuthority> getRolesFromToken(String authToken) {
        List<SimpleGrantedAuthority> roles = null;
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken).getBody();
        Boolean isAdmin = claims.get("isAdmin", Boolean.class);
        Boolean isSeller = claims.get("isSeller", Boolean.class);
        Boolean isBuyer = claims.get("isBuyer", Boolean.class);
        if (isAdmin != null && isAdmin == true) {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if (isSeller != null && isSeller == true) {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_SELLER"));
        }
        if (isBuyer != null && isBuyer == true) {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_BUYER"));
        }
        return roles;
    }
}
