package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static java.awt.font.TransformAttribute.IDENTITY;

@Entity
@Table(name = "Usuarios")
public class UsuarioEntity {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iduser;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    @ElementCollection
    @CollectionTable(name = "usuarios_tareas" // Nombre de la tabla de la colección
    ,joinColumns = @JoinColumn(name = "iduser"))// Clave foránea para la relación
    @Column(name = "idtarea") // Nombre de la columna para los IDs de las segunda entidad
    private List<Long> idstareas = new ArrayList<Long>();

    //CONSTRUCTOR GENERAL, CON LOS DATOS QUE SE SOLICITARAN PARA LA CONSTRUCCION DE ESTA CLASE
    public UsuarioEntity(String nombre,String apellido, String correo, String password) {
        this.apellido = apellido;
        this.correo = correo;
        this.iduser = iduser;
        this.nombre = nombre;
        this.password = password;
    }
    //constuctor vacio -> buena practica
    public UsuarioEntity() {}

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Long> getIdstareas() {
        return idstareas;
    }

    public void setIdstareas(List<Long> idstareas) {
        this.idstareas = idstareas;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
