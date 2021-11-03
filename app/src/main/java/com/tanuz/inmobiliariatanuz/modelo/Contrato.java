package com.tanuz.inmobiliariatanuz.modelo;

import java.io.Serializable;


public class Contrato implements Serializable {
    private int idContrato;
    private String fechaInicio;
    private String fechaFin;
    private Inquilino inquilino;
    private int inquilinoId;
    private Inmueble inmueble;
    private int inmuebleId;

    public Contrato() {}

    public Contrato(int idContrato, String fechaInicio, String fechaFin, Inquilino inquilino, int inquilinoId, Inmueble inmueble, int inmuebleId) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inquilino = inquilino;
        this.inquilinoId = inquilinoId;
        this.inmueble = inmueble;
        this.inmuebleId = inmuebleId;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public int getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(int inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }
}



