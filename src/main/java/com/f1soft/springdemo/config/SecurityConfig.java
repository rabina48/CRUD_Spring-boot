package com.f1soft.springdemo.config;

import com.f1soft.springdemo.jwt.JwtUsernameAndPasswordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication. AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


   @Qualifier("myUserDetailServices")
    @Autowired
    private  UserDetailsService userDetailsService;

   @Autowired
   private DataSource dataSource;


   @Override
   protected  void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
       authenticationManagerBuilder
               .inMemoryAuthentication()
               .withUser("admin").password(passwordEncoder().encode("admin"))
               .roles("ADMIN")
               .and()
               .withUser("rab").password(passwordEncoder().encode("123")).roles("USER")
               .and()
               .withUser("Assistan").password(passwordEncoder().encode("manager"))
               .roles("ASSISTAN").authorities("PUT","EDIT");
   }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
               .csrf().disable()

                //session wont be store in database as it used to preciously
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordFilter(authenticationManager()))
                .authorizeRequests()

//                .anyRequest().authenticated()
//                .and()
//
//                .formLogin()

                .antMatchers("/index.html").authenticated()
                .antMatchers("/profile/profile.html").authenticated()
                .antMatchers("/admin.html").hasRole("ADMIN")
                .antMatchers("/home.html").hasAnyRole("ADMIN","MANAGER")
                .antMatchers("/user").authenticated()
                .and()


                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index.html")
                .and()
                .httpBasic();




    }



    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
