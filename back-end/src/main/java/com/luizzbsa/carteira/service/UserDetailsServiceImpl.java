package com.luizzbsa.carteira.service;

import com.luizzbsa.carteira.model.entity.Usuario;
import com.luizzbsa.carteira.model.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    UsuarioDAO repository;
    @Autowired
    public UserDetailsServiceImpl(UsuarioDAO repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return new UserDetailsImpl(usuario);
    }
}
