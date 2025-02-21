package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.TareaEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.TareasRepository;
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
    @Autowired
    private TareasRepository tareasRepository;
    public UsuarioEntity register(String nombre, String apellido, String correo, String password ){
        UsuarioEntity existecorreo=usuarioRepository.findByCorreo(correo);
        if (existecorreo == null) {
            UsuarioEntity usuario = new UsuarioEntity(nombre, apellido, correo, password);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public UserDTO login(String correo, String password) {
        UsuarioEntity usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return new UserDTO(usuario.getIduser(),usuario.getNombre(), usuario.getApellido(), usuario.getCorreo());
        }
        return null;
    }


    @Transactional
    public List<TareaEntity> obtenerTareas(long id){
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        UsuarioEntity user = usuario.get();
        Hibernate.initialize(user.getIdstareas());
        List<Long> tareas = user.getIdstareas();
        List<TareaEntity> tareasentity;
        tareasentity = tareasRepository.findAllById(tareas);
        return tareasentity;
    }

    @Transactional
    public TareaEntity crearTarea(long iduser, String descripcion) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findById(iduser);
        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        UsuarioEntity usuario = usuarioOpt.get();
        TareaEntity tarea = new TareaEntity(descripcion);
        tareasRepository.save(tarea);

        usuario.getIdstareas().add(tarea.getIdtarea());
        usuarioRepository.save(usuario);
        return tarea;
    }


    @Transactional
    public int cambiarestado(long idtarea, int estado){
        TareaEntity tarea = tareasRepository.findById(idtarea).get();
        tarea.setEstado(estado);
        tareasRepository.save(tarea);
        return estado;
    }

    @Transactional
    public boolean eliminartarea(long iduser,long idtarea){
        UsuarioEntity user = usuarioRepository.findById(iduser).get();
        Hibernate.initialize(user.getIdstareas());
        List<Long> tareas = user.getIdstareas();
        if(tareas.contains(idtarea)){
            tareas.remove(idtarea);
            user.setIdstareas(tareas);
            usuarioRepository.save(user);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean modificartarea(long iduser, long idtarea, String newdescripcion) {
        Optional<TareaEntity> tareaOpt = tareasRepository.findById(idtarea);

        if (tareaOpt.isPresent()) {
            TareaEntity tarea = tareaOpt.get();
            tarea.setDescripcion(newdescripcion);
            tareasRepository.save(tarea);
            return true;
        }
        return false;
    }

}
