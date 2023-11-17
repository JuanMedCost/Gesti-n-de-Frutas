package com.example.proyectoentradafrutasjavafx;

public class Agricultor {

    private int id;
    private String nombre;

    private String dni;

    private String direccion;


    public Agricultor(int id, String nombre, String dni, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;

    }

    public Agricultor(){

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String toString(){
        return nombre;
    }

}
