package com.example.ExamenSem10_Jordy_Caichihua.domain.ports.in;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Usuario;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsuarioUseCase {
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> getUsuario(Long id);
    String loginWithUser(Map<String, String> requestMap);
    Optional<Usuario> updateUsuario(Long id, Usuario usuario);
    List<Usuario> findAll();
    Usuario deleteUsuario(Long id);
}
