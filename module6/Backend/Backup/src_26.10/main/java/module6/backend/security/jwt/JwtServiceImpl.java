package module6.backend.security.jwt;

import module6.backend.entity.account.Account;
import module6.backend.payload.request.LoginRequest;
import module6.backend.payload.response.JwtResponse;
import module6.backend.repository.IAccountRepository;
import module6.backend.security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtServiceImpl implements UserDetailsService {
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	public JwtResponse createJwtToken(LoginRequest loginRequest) throws Exception {
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();
		authenticate(username , password);

		UserDetails userDetails = loadUserByUsername(username);
		String newGeneratedToken = jwtUtils.generateToken(userDetails);

		Account account = accountRepository.findAccountByUsername(username);
		return new JwtResponse(account , newGeneratedToken);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findAccountByUsername(username);
		if (account != null) {
			return new org.springframework.security.core.userdetails.User(
					account.getUsername() ,
					account.getPassword() ,
					getAuthority(account)
			);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	private Set getAuthority(Account account) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		account.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});
		return authorities;
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