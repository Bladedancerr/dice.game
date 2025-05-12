package com.lasha.dice.game.service;

import com.lasha.dice.game.dto.JwtResponseDto;
import com.lasha.dice.game.dto.LoginUserRequestDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService
{
    private String SECRET_KEY;

    public JwtService(@Value("${jwt.secret}") String secretKey)
    {
        this.SECRET_KEY = secretKey;

        if(this.SECRET_KEY == null || this.SECRET_KEY.isEmpty())
        {
            this.SECRET_KEY = secretKey();
            System.out.println("Generated new secret key: " + this.SECRET_KEY);
        }
    }

    public JwtResponseDto generateToken(LoginUserRequestDto userLoginDto)
    {
        Map<String, Object> claims = new HashMap<>();
        var temp = Jwts.builder()
                .setClaims(claims)
                .setSubject(userLoginDto.getUsername())
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 3))
                .signWith(getKey())
                .compact();

        return new JwtResponseDto(temp);
    }

    public String secretKey()
    {
        try
        {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new RuntimeException("Error generating secret key", e);
        }
    }

    private Key getKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, String username)
    {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new java.util.Date());
    }

    private Date extractExpiration(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function <Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
