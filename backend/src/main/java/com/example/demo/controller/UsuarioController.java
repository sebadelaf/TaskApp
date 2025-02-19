package com.example.demo.controller;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public UsuarioEntity register(@RequestBody UsuarioEntity user){
        return usuarioService.register(user.getNombre(), user.getApellido(), user.getCorreo(), user.getPassword());
    }

    @PostMapping("/login")
    public UsuarioEntity login(@RequestBody UsuarioEntity user){
        return usuarioService.login(user.getCorreo(), user.getPassword());
    }

    @GetMapping("/tareas/{iduser}")
    public List<Long> tareas(@PathVariable long iduser){
        return usuarioService.obtenerTareas(iduser);
    }


}
