package com.tanuz.inmobiliariatanuz.modelo;



import java.io.Serializable;
import java.util.Objects;

public class Inmueble implements Serializable {
    private int idInmueble;
    private Propietario duenio;
    private int propietarioId;
    private String direccion;
    private String uso;
    private String tipo;
    private int ambientes;
    private double precio;

    //En falso significa que el innmueble no está disponible por alguna falla en el mismo.
    private boolean estado=true;
    private String imagen;


    public Inmueble() {

    }

    public Inmueble(int idInmueble, Propietario duenio, int propietarioId, String direccion, String uso, String tipo, int ambientes, double precio, boolean estado, String imagen) {
        this.idInmueble = idInmueble;
        this.duenio = duenio;
        this.propietarioId = propietarioId;
        this.direccion = direccion;
        this.uso = uso;
        this.tipo = tipo;
        this.ambientes = ambientes;
        this.precio = precio;
        this.estado = estado;
        this.imagen = imagen;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Propietario getDuenio() {
        return duenio;
    }

    public void setDuenio(Propietario duenio) {
        this.duenio = duenio;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrlImagen() {
      if(imagen != null){
          String urlBase = "http://192.168.0.103:45455/";
          String url = urlBase + imagen.replace("\\", "/");

          return url;

      }else {
          return "http://www.secsanluis.com.ar/servicios/departamento1.jpg";
      }

    }
}



