package com.luizzbsa.carteira.service;

import com.luizzbsa.carteira.infra.SecurityConfiguration;
import com.luizzbsa.carteira.model.dto.CriarUsuarioDTO;
import com.luizzbsa.carteira.model.dto.LoginDto;
import com.luizzbsa.carteira.model.dto.TokenJWTDTO;
import com.luizzbsa.carteira.model.entity.Usuario;
import com.luizzbsa.carteira.model.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private AuthenticationManager authenticationManager;
    private JwtTokenService jwtTokenService;
    private UsuarioDAO repository;
    private SecurityConfiguration securityConfiguration;

    @Autowired
    public UsuarioService(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, UsuarioDAO repository, SecurityConfiguration securityConfiguration) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.repository = repository;
        this.securityConfiguration = securityConfiguration;
    }

    public TokenJWTDTO authenticateUser(LoginDto loginUserDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.senha());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new TokenJWTDTO(jwtTokenService.generateToken(userDetails));
    }


    public void createUser(CriarUsuarioDTO criarUsuarioDto) {
        Usuario novoUsuario = new Usuario(criarUsuarioDto, securityConfiguration);
        repository.save(novoUsuario);
        System.out.println(novoUsuario.getSenha());

    }
}
