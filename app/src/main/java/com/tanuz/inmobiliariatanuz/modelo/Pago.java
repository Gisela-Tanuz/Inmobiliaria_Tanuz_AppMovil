package com.tanuz.inmobiliariatanuz.modelo;



import java.io.Serializable;


public class Pago implements Serializable {
    private int idPago;
    private int nroDePago;
    private int contratoId;
    private double importe;
    private String fecha;



    public Pago() {}

    public Pago(int idPago, int nroDePago, int contratoId, double importe, String fecha) {
        this.idPago = idPago;
        this.nroDePago = nroDePago;
        this.contratoId = contratoId;
        this.importe = importe;
        this.fecha = fecha;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getNroDePago() {
        return nroDePago;
    }

    public void setNroDePago(int nroDePago) {
        this.nroDePago = nroDePago;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}



