package by.step.test.security.utill;

import by.step.test.security.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtill {

    @Value("${jwt.token.word}")
    private String word;
    @Value("${jwt.token.time}")
    private int time;


   public String generateJwtToken(Authentication authentication){

       UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
       String token = Jwts.builder().setSubject(userDetails.getUsername())
               .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+time))
               .signWith(SignatureAlgorithm.HS512, word).compact();
       return token;
   }

   public boolean validateJwtToken(String jwt){
       try {
           Jwts.parser().setSigningKey(word).parseClaimsJws(jwt);
           return true;
       } catch (ExpiredJwtException
               | IllegalArgumentException
               | SignatureException
               | MalformedJwtException
               | UnsupportedJwtException e) {
           e.printStackTrace();
       }
       return false;
   }

   public  String getUserNameFromToken(String jwt){
       return Jwts.parser().setSigningKey(word).parseClaimsJws(jwt)
               .getBody().getSubject();
   }

}
