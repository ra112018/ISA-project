package com.example.projectIsa.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.users.dto.UserDTO;
import com.example.projectIsa.users.dto.UserTokenStateDTO;
import com.example.projectIsa.users.mapper.UserMapper;
import com.example.projectIsa.users.model.User;
import com.example.projectIsa.users.security.JwtAuthenticationRequest;
import com.example.projectIsa.users.security.TokenUtils;
import com.example.projectIsa.users.service.impl.CustomUserDetailsService;
import com.example.projectIsa.users.service.impl.UserService;

@RestController
@RequestMapping(value = "/auth")
public class LoginController {

	 @Autowired
	 private TokenUtils tokenUtils;

	 @Autowired
	 private AuthenticationManager authenticationManager;

	 @Autowired
	 private CustomUserDetailsService userDetailsService;

	 @Autowired
	 private UserService userService;
	 
	 private PasswordEncoder passwordEncoder;


	 @PostMapping("/login")
	 public ResponseEntity createAuthenticationToken (@RequestBody JwtAuthenticationRequest authenticationRequest,
	                                                                         HttpServletResponse response) {
		 
		try {
			Authentication authentication = authenticationManager
				 .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						 authenticationRequest.getPassword()));
			
	        SecurityContext ctx = SecurityContextHolder.createEmptyContext();
	        SecurityContextHolder.setContext(ctx);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	
	        User user = (User) authentication.getPrincipal();
	        String jwt = tokenUtils.generateToken(user);
	        int expiresIn = tokenUtils.getExpiredIn();
	
	        return ResponseEntity.ok(new UserTokenStateDTO(UserMapper.MapToDTO(user), jwt, expiresIn));
		}
		catch(Exception e){
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
    }

 
    @PostMapping(value = "/refresh")
    public ResponseEntity<UserTokenStateDTO> refreshAuthenticationToken(HttpServletRequest request) {

        String token = tokenUtils.getToken(request);
        String username = this.tokenUtils.getUsernameFromToken(token);
        User user = (User) this.userDetailsService.loadUserByUsername(username);

        if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = tokenUtils.refreshToken(token);
            int expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenStateDTO(UserMapper.MapToDTO(user), refreshedToken, expiresIn));
        } else {
            UserTokenStateDTO userTokenState = new UserTokenStateDTO();
            return ResponseEntity.badRequest().body(userTokenState);
        }
    }
}
