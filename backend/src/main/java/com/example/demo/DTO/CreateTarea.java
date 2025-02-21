package com.example.demo.DTO;

public class CreateTarea {
    private long iduser;
    private String descripcion;

    public CreateTarea(String descripcion, long iduser) {
        this.descripcion = descripcion;
        this.iduser = iduser;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }
}
