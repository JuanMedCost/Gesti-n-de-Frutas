package com.example.proyectoentradafrutasjavafx;

import java.util.Date;

public class Entrada {
    private int id;
    private String fecha;
    private int nombreAgricultor;
    private int nombreFruta;
    private String kilos;
    private String variedad;

    public Entrada(int id, String fecha, int nombreAgricultor, int nombreFruta, String kilos, String variedad) {
        this.id = id;
        this.fecha = fecha;
        this.nombreAgricultor = nombreAgricultor;
        this.nombreFruta = nombreFruta;
        this.kilos = kilos;
        this.variedad = variedad;
    }

    public Entrada(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNombreAgricultor() {
        return nombreAgricultor;
    }

    public void setNombreAgricultor(int nombreAgricultor) {
        this.nombreAgricultor = nombreAgricultor;
    }

    public int getNombreFruta() {
        return nombreFruta;
    }

    public void setNombreFruta(int nombreFruta) {
        this.nombreFruta = nombreFruta;
    }

    public String getKilos() {
        return kilos;
    }

    public void setKilos(String kilos) {
        this.kilos = kilos;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }
}
