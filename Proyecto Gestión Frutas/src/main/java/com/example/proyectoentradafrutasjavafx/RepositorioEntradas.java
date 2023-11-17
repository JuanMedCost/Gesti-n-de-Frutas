package com.example.proyectoentradafrutasjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class RepositorioEntradas {

    Connection conexion;
    public RepositorioEntradas(){
        setConexion();
    }
    public void setConexion(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cooperativa","root","");
            Statement st=conexion.createStatement();

            //Si no existe la tabla de fruta, la creo
            st.execute("CREATE TABLE IF NOT EXISTS entradas(id_entrada INT NOT NULL AUTO_INCREMENT,fecha_entrada DATE, id_agricultor INT ,id_fruta INT, kgs INT, FOREIGN KEY (id_agricultor) REFERENCES agricultores (id_agricultores), FOREIGN KEY (id_fruta) REFERENCES frutas (id_frutas),  PRIMARY KEY (id_entrada));");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void insertarEntradaa(Entrada ent){

        PreparedStatement st = null;

        try {
            st = conexion.prepareStatement("INSERT INTO entradas values(NULL, ?,?,?,?)");
            st.setDate(1, Date.valueOf(ent.getFecha()));
            st.setInt(2, ent.getNombreAgricultor());
            st.setInt(3, ent.getNombreFruta());
            st.setInt(4, Integer.parseInt(ent.getKilos()));

            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ObservableList<Entrada> getEntradass(){
        ObservableList<Entrada> entradaa= FXCollections.observableArrayList();
        try {

            PreparedStatement st=conexion.prepareStatement("SELECT * FROM entradas");
            ResultSet rs=st.executeQuery();

            while(rs.next()){

                Entrada auxiliarDeEntradas = new Entrada();
                //auxiliarAgricultor.setId(rs.getInt("id"));
                auxiliarDeEntradas.setNombreAgricultor(rs.getInt("id_agricultor"));
                auxiliarDeEntradas.setNombreFruta(rs.getInt("id_fruta"));
                auxiliarDeEntradas.setKilos(rs.getString("kgs"));
                auxiliarDeEntradas.setId(rs.getInt("id_entrada"));
                auxiliarDeEntradas.setFecha(rs.getString("fecha_entrada"));
                entradaa.add(auxiliarDeEntradas);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entradaa;
    }
}
