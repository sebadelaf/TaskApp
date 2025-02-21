package com.example.demo.service;

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
    public TareaEntity crearTarea(long iduser,String decripcion){
        TareaEntity tarea = new TareaEntity(decripcion);
        tareasRepository.save(tarea);
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(iduser);
        UsuarioEntity user = usuario.get();
        user.getIdstareas().add(tarea.getIdtarea());
        usuarioRepository.save(user);
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
    public boolean modificartarea(long iduser,long idtarea,String newdescripcion){
        UsuarioEntity user = usuarioRepository.findById(iduser).get();
        Hibernate.initialize(user.getIdstareas());
        List<Long> tareas = user.getIdstareas();
        if(tareas.contains(idtarea)){
          List<TareaEntity> tareasentity=obtenerTareas(iduser);
          for(TareaEntity tarea:tareasentity){
              if(tarea.getIdtarea()==idtarea){
                  tarea.setDescripcion(newdescripcion);
                  tareasRepository.save(tarea);
                  return true;
              }
          }
        }
        return false;
    }

}
