package com.example.demo.DTO;

public class ModificarTarea {
    long iduser;
    long idtarea;
    String newdesc;

    public ModificarTarea(long idtarea, long iduser, String newdesc) {
        this.idtarea = idtarea;
        this.iduser = iduser;
        this.newdesc = newdesc;
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

    public String getNewdesc() {
        return newdesc;
    }

    public void setNewdesc(String newdesc) {
        this.newdesc = newdesc;
    }
}
