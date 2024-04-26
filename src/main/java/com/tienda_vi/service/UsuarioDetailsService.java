package com.tienda_vi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

