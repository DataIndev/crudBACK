package com.tutorial.crud.security.jwt;

import com.tutorial.crud.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

//Genera el Token, valida que este bien forrmado y que no este expirado.. etc
@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.expiration}")
    private long expiration;

    final Key key = secretKeyFor(SignatureAlgorithm.HS256);


    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(key)
                .compact();

    }

    public String getUserNameFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token).getBody().getSubject();


    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token);


            return true;

        }catch(MalformedJwtException e){
            logger.error("Token mal formado");
        }catch(UnsupportedJwtException e){
            logger.error("Token no soportado");
        }catch(ExpiredJwtException e){
            logger.error("Token Expired");
        }catch(IllegalArgumentException e){
            logger.error("Token Vacio");
        }catch(SignatureException e){
            logger.error("Fail en la firma");
        }
        return false;
    }

}
