package com.paymentapi.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JWTUtil {

//    /**
//     *TRUELAYER API TEST ENVIRONMENT
//     */
//    private final String TOKEN_URL = "https://auth.truelayer-sandbox.com/connect/token";
//    private static String client_id = "sandbox-admin-279c9b";
//    private static String client_secret = "30c34234-79ae-4ab3-99af-2887f19f5361";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//
//    public Token generateToken(){
//
//        Client currentClient = new Client(client_id, client_secret);
//        log.info("Test Client provided");
//        Token token = restTemplate.postForObject(TOKEN_URL, currentClient, Token.class);
//        log.info("True layer api consumed for token");
//
//
//        return token;
//    }


//    public String generateToken(Client client){
//
//        Map<String,Object> claims = new HashMap<>();
//        claims.put("username",user.getUsername());
//        claims.put("email",user.getEmail());
//        return createToken(claims,user.getUsername());
//    }
//
//    private String createToken(Map<String,Object> claims,String username){
//
//        return Jwts
//                .builder()
//                .setClaims(claims)
//                .setSubject(username)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *10)) //10 hours token validity
//                .signWith(SignatureAlgorithm.HS256,secret).compact();
//
//    }
//
//    private Claims extractAllClaims(String token){
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//    }
//
//    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    public String extractUsername(String token){
//        return extractClaim(token,Claims::getSubject);
//    }
//
//    public Date extractExpiration(String token){
//        return extractClaim(token,Claims::getExpiration);
//
//    }
//
//    private Boolean isTokenExpired(String token){
//        return extractExpiration(token).before(new Date());
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails){
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }




}
