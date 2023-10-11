package com.example.ExamenSem10_Jordy_Caichihua.application.useCase;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Usuario;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.in.UsuarioUseCase;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.out.UsuarioRepositoryPort;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsuarioUseCaseImpl implements UsuarioUseCase {
    private final UsuarioRepositoryPort usuarioRespositoryPort;
    public UsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRespositoryPort){
        this.usuarioRespositoryPort = usuarioRespositoryPort;
    }
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRespositoryPort.saveUser(usuario);
    }

    @Override
    public Optional<Usuario> getUsuario(Long id) {

        return usuarioRespositoryPort.findUsuarioId(id);
    }

    @Override
    public String loginWithUser(Map<String, String> requestMap) {
        return usuarioRespositoryPort.loginWithUser(requestMap);
    }

    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {
        return usuarioRespositoryPort.update(id,usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRespositoryPort.getAll();
    }

    @Override
    public Usuario deleteUsuario(Long id) {
        return usuarioRespositoryPort.deleteById(id);
    }
}
