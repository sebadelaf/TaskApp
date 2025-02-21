package com.example.demo.DTO;

public class UserDTO {
    private long iduser;
    private String nombre;
    private String apellido;
    private String correo;
    public UserDTO() {}

    public UserDTO(long iduser,String nombre,String apellido, String correo) {
        this.apellido = apellido;
        this.correo = correo;
        this.iduser = iduser;
        this.nombre = nombre;
    }

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
}
