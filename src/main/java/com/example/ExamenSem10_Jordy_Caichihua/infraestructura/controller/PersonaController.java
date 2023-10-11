package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.controller;

import com.example.ExamenSem10_Jordy_Caichihua.application.service.PersonaService;
import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personas")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping
    public List<Persona> listarPersonas(){
        return personaService.findAll();
    }

    @PostMapping("/crearPersona")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
        Persona nuevoPersona = personaService.crearPersona(persona);
        return new ResponseEntity<>(nuevoPersona, HttpStatus.CREATED);
    }

    @GetMapping("/{personaId}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long personaId){
        return personaService.getPersona(personaId)
                .map(persona -> new ResponseEntity<>(persona,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{personaId}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long personaId, @RequestBody Persona persona) {
        return personaService.updatePersona(personaId, persona)
                .map(per-> new ResponseEntity<>(per, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Long id){
        Persona personarEl = personaService.deletePersona(id);
        return ResponseEntity.ok(personarEl);
    }

}
