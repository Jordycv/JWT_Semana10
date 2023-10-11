package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.repository;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Usuario;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.out.UsuarioRepositoryPort;
import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity.UsuarioEntity;
import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.security.CustomerDetailService;
import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.security.Jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UsuarioJpaRepositoryAdapter implements UsuarioRepositoryPort {
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomerDetailService customerDetailService;

    public UsuarioJpaRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomerDetailService customerDetailService) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customerDetailService = customerDetailService;
    }

    @Override
    public Usuario saveUser(Usuario usuario) {
        UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuario);
        usuarioEntity.setFechaCrea(new Date());
        usuarioEntity.setFechaMod(new Date());
        UsuarioEntity saveUsuarioEntity = usuarioJpaRepository.save(usuarioEntity);
        return saveUsuarioEntity.toDomainModel();
    }
    @Override
    public Optional<Usuario> findUsuarioId(Long id) {

        return usuarioJpaRepository.findById(id).map(UsuarioEntity::toDomainModel);
    }

    @Override
    public String loginWithUser(Map<String, String> requestMap) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("usuario"), requestMap.get("password")));
            if(authentication.isAuthenticated()){
                String token_generado = jwtUtil.generateToken(
                        customerDetailService.getUserDetail().getUsuario(),
                        null
                );
                return token_generado;
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {


        if (usuarioJpaRepository.existsById(usuario.getId())) {
            UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuario);
            UsuarioEntity updatedUsuarioEntity = usuarioJpaRepository.save(usuarioEntity);
            return Optional.of(updatedUsuarioEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public List<Usuario> getAll() {
        List<UsuarioEntity> lista = usuarioJpaRepository.findAll();
        List<Usuario> listaFinal = new ArrayList<>();
        for(UsuarioEntity usuarioEntity : lista){
            listaFinal.add(usuarioEntity.toDomainModel());
        }
        return listaFinal;
    }

    @Override
    public Usuario deleteById(Long id) {
        Usuario usuarioExistente=findUsuarioId(id).get();
        UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuarioExistente);

        UsuarioEntity saveUsuarioEntity = usuarioJpaRepository.save(usuarioEntity);

        return saveUsuarioEntity.toDomainModel();
    }
}
