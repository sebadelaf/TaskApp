package com.example.demo.DTO;

public class CambiarState {
    long idtarea;
    int estado;

    public CambiarState(int estado, long idtarea) {
        this.estado = estado;
        this.idtarea = idtarea;
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
