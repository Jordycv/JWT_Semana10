package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.controller;

import com.example.ExamenSem10_Jordy_Caichihua.application.service.UsuarioService;
import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public String loginWithUser(@RequestBody(required = true) Map<String, String> requestMap){

        return usuarioService.loginWithUser(requestMap);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuarioId, usuario)
                .map(usur-> new ResponseEntity<>(usur, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/getAll")
    public List<Usuario> getAll(){

        return usuarioService.findAll();
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long usuarioId){
        return usuarioService.getUsuario(usuarioId)
                .map(usur -> new ResponseEntity<>(usur,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Long id){
        Usuario usuarioEl = usuarioService.deleteUsuario(id);
        return ResponseEntity.ok(usuarioEl);
    }

}
