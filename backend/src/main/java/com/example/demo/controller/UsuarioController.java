package com.example.demo.controller;

import com.example.demo.DTO.*;
import com.example.demo.entity.TareaEntity;
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
    public UserDTO login(@RequestBody UsuarioEntity user){
        return usuarioService.login(user.getCorreo(), user.getPassword());
    }

    @GetMapping("/tareas/{iduser}")
    public List<TareaEntity> tareas(@PathVariable long iduser){
        return usuarioService.obtenerTareas(iduser);
    }

    @PostMapping("/crearTarea")
    public TareaEntity crearTarea(@RequestBody CreateTarea ct){
        long iduser = ct.getIduser();
        String descripcion = ct.getDescripcion();
        return usuarioService.crearTarea(iduser, descripcion);
    }

    @PostMapping("/cambiarestado")
    public int cambiarestado(@RequestBody CambiarState cs){
        long idtarea = cs.getEstado();
        int estado = cs.getEstado();
        return usuarioService.cambiarestado(idtarea, estado);
    }

    @PostMapping("/eliminartarea")
    public boolean eliminartarea(@RequestBody EliminarTarea et){
        long idtarea = et.getIdtarea();
        long iduser = et.getIduser();
        return usuarioService.eliminartarea(iduser,idtarea);
    }

    @PostMapping("/modificartarea")
    public boolean modificararea(@RequestBody ModificarTarea mo){
        long idtarea = mo.getIdtarea();
        long iduser = mo.getIduser();
        String newds= mo.getNewdesc();
        return usuarioService.modificartarea(idtarea, iduser, newds);
    }

}
