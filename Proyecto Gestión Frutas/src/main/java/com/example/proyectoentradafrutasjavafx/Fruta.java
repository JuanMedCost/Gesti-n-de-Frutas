package com.example.proyectoentradafrutasjavafx;

public class Fruta {
    private int id;
    private String nombreFruta;

    private String variedad;

    private String calibre;

    public Fruta(int id, String nombreFruta, String variedad, String calibre) {
        this.id = id;
        this.nombreFruta = nombreFruta;
        this.calibre = calibre;
    }

    public Fruta(){

    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreFruta() {
        return nombreFruta;
    }

    public void setNombreFruta(String nombreFruta) {
        this.nombreFruta = nombreFruta;
    }

    public String toString(){
        return nombreFruta;
    }
}
