package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.security;

import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity.UsuarioEntity;
import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.repository.UsuarioJpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class CustomerDetailService implements UserDetailsService {
    private final UsuarioJpaRepository usuarioJpaRepository;
    private UsuarioEntity userDetail;
    public CustomerDetailService(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetail = usuarioJpaRepository.findByUsuario(username);
        if(!Objects.isNull(userDetail)&&userDetail.getEstado().equals(1)){
            return new User(userDetail.getUsuario(), userDetail.getPassword(), new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }
    public UsuarioEntity getUserDetail() {
        return userDetail;
    }
}
