package com.yumm.recipe.service;

import static java.util.Collections.singletonList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yumm.recipe.entities.User;
import com.yumm.recipe.repository.UserRepository;

@Service
public class UserService  implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(final UserRepository userRepository )
	{
		this.userRepository=userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<User> record = userRepository.findByUserName(username);

        if (record.isEmpty()) {
            throw new UsernameNotFoundException("User not found - " + username);
        }

        final User user = record.get();

      
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
	}

	
	public User save(final User user) {
        return userRepository.save(user);
    }
}
