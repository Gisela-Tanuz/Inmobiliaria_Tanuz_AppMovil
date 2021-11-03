package com.tanuz.inmobiliariatanuz.modelo;

import android.util.Log;

import com.tanuz.inmobiliariatanuz.R;

import java.io.Serializable;


public class Propietario implements Serializable {
    private int idPropietario;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String telefono;
    private String usuario;
    private String avatarProp;


    public Propietario(){}

    public Propietario(int idPropietario, String dni, String nombre, String apellido, String email, String contraseña, String telefono, String usuario, String avatarProp) {
        this.idPropietario = idPropietario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.usuario = usuario;
        this.avatarProp = avatarProp;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAvatarProp() {
        return avatarProp;
    }

    public void setAvatarProp(String avatarProp) {
        this.avatarProp = avatarProp;
    }


    public String getUrlFotoProp() {
           String urlBase = "http://192.168.0.103:45455/";
           String url = urlBase + avatarProp;

           return url;

    }
    @Override
    public String toString() {
        return "Propietario{" +
                "idPropietario=" + idPropietario +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario='" + usuario + '\'' +
                ", avatarProp='" + avatarProp + '\'' +
                '}';
    }
}




