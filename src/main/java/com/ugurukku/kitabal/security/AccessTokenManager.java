package com.ugurukku.kitabal.security;

import com.ugurukku.kitabal.entities.User;
import com.ugurukku.kitabal.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class AccessTokenManager implements TokenGenerator<User>,TokenReader<Claims>{

private final SecurityProperties securityProperties;

    @Override
    public String generate(User user) {

        Claims claims = Jwts.claims();
        claims.put("email",user.getEmail());

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getAccessTokenValidityTime());

        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public Claims read(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public String extractUsername(String token) {
        return (read(token).get("email",String.class));
    }

    public boolean isTokenExpired(String token){
        return read(token).getExpiration().before(new Date());
    }



    public boolean isTokenValid(String jwt, UserDetails user) {
        final String email = extractUsername(jwt);
        return (email.equals(user.getUsername())) && !isTokenExpired(jwt);
    }
}
