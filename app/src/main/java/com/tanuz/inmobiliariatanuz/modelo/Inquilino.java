package com.tanuz.inmobiliariatanuz.modelo;

import java.io.Serializable;

public class Inquilino implements Serializable {
    private int idInquilino;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private String nombreGarante;
    private String direccionGarante;
    private String telGarante;
    private String lugarDeTrabajo;

    public Inquilino() {
    }

    public Inquilino(int idInquilino, String nombre, String apellido, String dni, String telefono, String email, String nombreGarante, String direccionGarante, String telGarante, String lugarDeTrabajo) {
        this.idInquilino = idInquilino;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.nombreGarante = nombreGarante;
        this.direccionGarante = direccionGarante;
        this.telGarante = telGarante;
        this.lugarDeTrabajo = lugarDeTrabajo;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public String getDireccionGarante() {
        return direccionGarante;
    }

    public void setDireccionGarante(String direccionGarante) {
        this.direccionGarante = direccionGarante;
    }

    public String getTelGarante() {
        return telGarante;
    }

    public void setTelGarante(String telGarante) {
        this.telGarante = telGarante;
    }

    public String getLugarDeTrabajo() {
        return lugarDeTrabajo;
    }

    public void setLugarDeTrabajo(String lugarDeTrabajo) {
        this.lugarDeTrabajo = lugarDeTrabajo;
    }
}
