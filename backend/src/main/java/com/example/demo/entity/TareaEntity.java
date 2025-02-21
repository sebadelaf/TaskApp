package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Tareas")
public class TareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtarea;
    private String Descripcion;
    private int estado;
    public TareaEntity() {}
    public TareaEntity(String Descripcion) {
        this.Descripcion = Descripcion;
        this.idtarea=idtarea;
        this.estado = 0;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public long getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(long idtarea) {
        this.idtarea = idtarea;
    }
}
