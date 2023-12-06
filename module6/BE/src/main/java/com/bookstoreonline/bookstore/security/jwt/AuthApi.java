package com.bookstoreonline.bookstore.security.jwt;

import com.bookstoreonline.bookstore.dao.account.AccountRepository;
import com.bookstoreonline.bookstore.entity.account.Account;
import com.bookstoreonline.bookstore.security.utils.JwtServiceImpl;
import com.bookstoreonline.bookstore.security.utils.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()
@RestController
public class AuthApi {
​
    @Autowired
    private JwtServiceImpl service;
​
    @Autowired
    private AuthenticationManager manager;
​
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
​
    @Autowired
    private AccountRepository accountRepository;
​
    @Autowired
    private AuthenticationManager authenticationManager;
​
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/auth/login" )
    @PostMapping()
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            String username = authRequest.getUsername();
            String password = authRequest.getPassword();
            authenticate(username , password);
            Authentication authentication = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            Account account = (Account) authentication.getPrincipal();
​
            UserDetails userDetails = service.loadUserByUsername(authRequest.getUsername());
            String accessToken = jwtTokenUtil.generateToken(account);
//            String accessToken = jwtTokenUtil.generateToken(account);
//            AuthResponse authResponse = new AuthResponse(account.getUsername(), accessToken);
            Account account1 = accountRepository.findAccountByUsername(authRequest.getUsername());
            JwtResponse jwtResponse = new JwtResponse(account1,accessToken);
​
            return ResponseEntity.ok(jwtResponse);
​
        } catch (BadCredentialsException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    private void authenticate(String username , String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username , password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED" , e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS" , e);
        }
    }
}
