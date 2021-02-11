package com.f1soft.springdemo.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

//Job is to verify the credentials
public class JwtUsernameAndPasswordFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtUsernameAndPasswordFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }



    //Performs actual authentication.
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
             //value that are obtained from user;

            JwtUsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), JwtUsernameAndPasswordAuthenticationRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );
           System.out.println("Authentication"+authentication.isAuthenticated());


            Authentication authenticaticate = authenticationManager.authenticate(authentication);
            System.out.println("Authentication"+authentication.isAuthenticated());
            return  authenticaticate;


        } catch (IOException e) {
            throw new RuntimeException(e);

        }


    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String key = "CharacterCharacterCharacterCharacterCharacterCharacterCharactera";

        Long now = System.currentTimeMillis();
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                // Convert to list of strings.
                // This is important because it affects the way we get them back in the Gateway.
                .claim("authorities", authResult.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 60 * 1000))  // in milliseconds
                .signWith(SignatureAlgorithm.HS512, key.getBytes())
                .compact();

              System.out.println("key"+key.length());


//               String token = Jwts.builder()
//                .setSubject(authResult.getName())
//                .claim("authorities",authResult.getAuthorities()) // claim is like a body
//                .setIssuedAt(new Date())
//                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
//                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
//                .compact();


        //sending the token to client

        response.addHeader("Authorization","Bearer " +token);
    }}
