package com.example.ExamenSem10_Jordy_Caichihua.domain.ports.out;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Usuario;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario saveUser(Usuario usuario);
    Optional<Usuario> findUsuarioId(Long id);
    String loginWithUser(Map<String, String> requestMap);
    Optional<Usuario> update(Long id, Usuario usuario);
    List<Usuario> getAll();
    Usuario deleteById(Long id);
}
