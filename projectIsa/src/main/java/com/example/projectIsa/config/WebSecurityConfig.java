package com.example.projectIsa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.projectIsa.users.security.RestAuthenticationEntryPoint;
import com.example.projectIsa.users.security.TokenAuthenticationFilter;
import com.example.projectIsa.users.security.TokenUtils;
import com.example.projectIsa.users.service.impl.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomUserDetailsService jwtUserDetailsService;


    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    
    
    @Autowired
    private TokenUtils tokenUtils;

    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

                .authorizeRequests().antMatchers("/auth/**").permitAll()
                .antMatchers("/client/registration").permitAll()
                .antMatchers("/client/activateAccount").permitAll() 
                
                .antMatchers("/client/getById/{id}").permitAll() 
                .antMatchers("/client/update").permitAll() 
                .antMatchers("/client/changePassword").permitAll() 

                .antMatchers("/registration-owner-instructor/**").permitAll()
                .antMatchers("/cottage/getAll").permitAll()
                .antMatchers("/cottage/search/{searchInput}").permitAll()
                .antMatchers("/boat/getAll").permitAll()
                .antMatchers("/boat/search/{searchInput}").permitAll()
                .antMatchers("/fishingInstructorAdventure/getAll").permitAll()
                .antMatchers("/fishingInstructorAdventure/search/{searchInput}").permitAll()
                
                .antMatchers("/clientDeleteAccountRequests/add").permitAll()
                .antMatchers("/clientDeleteAccountRequests/getAll").permitAll()
                .antMatchers("/clientDeleteAccountRequests/approve").permitAll()
                .antMatchers("/clientDeleteAccountRequests/deny").permitAll()


                .anyRequest().authenticated().and()

                .cors().and()

                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
                        BasicAuthenticationFilter.class);

                http.csrf().disable();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");
        web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
                "/**/*.css", "/**/*.js");
        web.ignoring().antMatchers(HttpMethod.PUT, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
                "/**/*.css", "/**/*.js");
    }

}
