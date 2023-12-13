package com.techguyseli.Eventster.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "87F9F332D2BAE62A506D7218B2E7244E69933A245B088E0F0927C41911FEF7298DB1E41D4B2E6404B45F126EF871FD7CEC28D526D97918E5AD4E6F539D8C82AF847283837561592DD46ED2B5D3FB1AA608B63C3EA3719E5D9FC4E101DC4D1B187766B6F1A93825BB89E4274BA02A70E43CB2D04C8DAF8377EB5F6794E446576B";

    public String extractUsername(String jwt){
        return extractClaim(jwt, Claims::getSubject);
    }

    private Claims extractAllClaims(String jwt){
        return Jwts
        .parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(jwt)
        .getBody();
    }

    public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
        Map<String, Object> extraClaims,
        UserDetails userDetails
    ){
        return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    public boolean isJwtValid(String jwt, UserDetails userDetails){
        final String username = extractUsername(jwt);

        Date expirationDate = extractClaim(jwt, Claims::getExpiration);

        return username.equals(userDetails.getUsername())
            && expirationDate.after(new Date(System.currentTimeMillis()));
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
