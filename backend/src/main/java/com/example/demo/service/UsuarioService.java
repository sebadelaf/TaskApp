package com.example.demo.service;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioEntity register(String nombre, String apellido, String correo, String password ){
        UsuarioEntity existecorreo=usuarioRepository.findByCorreo(correo);
        if(existecorreo==null){
            UsuarioEntity usuario = new UsuarioEntity(nombre,apellido,correo,password);
            return usuarioRepository.save(usuario);

        }
        return null;
    }

    public UsuarioEntity login(String correo, String password){
        UsuarioEntity usuario = usuarioRepository.findByCorreo(correo);

        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null; // Si la contraseña no coincide, devuelve null
    }

    @Transactional
    public List<Long> obtenerTareas(long id){
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        UsuarioEntity user = usuario.get();
        Hibernate.initialize(user.getIdstareas());
        List<Long> tareas = user.getIdstareas();
        return tareas;
    }
}
