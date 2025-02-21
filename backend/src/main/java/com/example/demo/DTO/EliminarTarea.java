package com.example.demo.DTO;

public class EliminarTarea {
    long iduser;
    long idtarea;
    public EliminarTarea() {}

    public EliminarTarea(long idtarea, long iduser) {
        this.idtarea = idtarea;
        this.iduser = iduser;
    }

    public long getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(long idtarea) {
        this.idtarea = idtarea;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }
}
