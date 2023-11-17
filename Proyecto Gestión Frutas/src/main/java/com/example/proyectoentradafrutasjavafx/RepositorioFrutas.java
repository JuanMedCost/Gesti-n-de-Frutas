package com.example.proyectoentradafrutasjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class RepositorioFrutas {

    Connection conexion;
    public RepositorioFrutas(){
        setConexion();
    }
    public void setConexion(){

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cooperativa","root","");
            Statement st=conexion.createStatement();

            //Si no existe la tabla de fruta, la creo
            st.execute("CREATE TABLE IF NOT EXISTS frutas(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,nombre varchar(255) UNIQUE,variedad varchar(255) NOT NULL, " +
                    "calibre VARCHAR(255))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Fruta> getFrutas(){
        ObservableList<Fruta> frutas= FXCollections.observableArrayList();
        try {

            PreparedStatement st=conexion.prepareStatement("SELECT * FROM frutas");
            ResultSet rs=st.executeQuery();

            while(rs.next()){

                //Convertimos los registros de la BD con los datos de frutas en objetos frutas
                //frutas.add(new Fruta(rs.getInt("id"), rs.getString("nombre"),rs.getString("variedad"),rs.getString("calibre")));
                Fruta aux = new Fruta();
                aux.setId(rs.getInt("id_frutas"));
                aux.setNombreFruta(rs.getString("nombre"));
                aux.setVariedad(rs.getString("variedad"));
                aux.setCalibre(rs.getString("calibre"));
                frutas.add(aux);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return frutas;
    }

    public void insertarFruta(Fruta f) {
        PreparedStatement st = null;
        try {
            st = conexion.prepareStatement("INSERT INTO frutas (nombre, variedad, calibre)" +
                    " VALUES (?, ?, ?);");
            st.setString(1, f.getNombreFruta());
            st.setString(2, f.getVariedad());
            st.setString(3, f.getCalibre());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
