package com.sehirefsaneleri.ws.auth;

import java.util.Base64;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.sehirefsaneleri.ws.shared.CurrentUser;
import com.sehirefsaneleri.ws.shared.Views.Base;
import com.sehirefsaneleri.ws.user.User;
import com.sehirefsaneleri.ws.user.UserRepository;

@RestController
public class AuthController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/api/1.0/auth")
	@JsonView(Base.class) 
	ResponseEntity<?> handleAuthentication(@CurrentUser User user) { 
		return ResponseEntity.ok(user);

	}

}
