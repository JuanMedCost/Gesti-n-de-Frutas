package com.example.proyectoentradafrutasjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class RepositorioAgricultores {

    static Connection conexion;
    public RepositorioAgricultores(){
        setConexion();
    }
    public void setConexion(){

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cooperativa","root","");
            Statement st=conexion.createStatement();

            //Si no existe la tabla de fruta, la creo
            st.execute("CREATE TABLE IF NOT EXISTS agricultores(id_agricultores INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255)," +
                    " dni VARCHAR(255),direccion VARCHAR(255))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    public ArrayList<Agricultor> getTodosLosAgricultores(){
        ArrayList<Agricultor> agricultores= new ArrayList<>();
        try {

            PreparedStatement st=conexion.prepareStatement("SELECT * FROM agricultores");
            ResultSet rs=st.executeQuery();

            while(rs.next()) {
                Agricultor aux = new Agricultor();
                aux.setId(rs.getInt("id_agricultores"));
                aux.setNombre(rs.getString("nombre"));
                aux.setDni(rs.getString("dni"));
                aux.setDireccion(rs.getString("direccion"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agricultores;
    }

    public static void insertarAgricultor(String nombre, String dni, String direccion){
        try {
            PreparedStatement ps=conexion.prepareStatement("INSERT INTO agricultores (nombre, dni, direccion) values(?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2,dni);
            ps.setString(3, direccion);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarAgricultorr(Agricultor ag){
        PreparedStatement st = null;
        try {
            st = conexion.prepareStatement("INSERT INTO agricultores (nombre, dni, direccion)" +
                    " VALUES (?, ?, ?);");
            st.setString(1, ag.getNombre());
            st.setString(2, ag.getDni());
            st.setString(3, ag.getDireccion());
            st.executeUpdate();

            st = conexion.prepareStatement("SELECT id_agricultores FROM agricultores WHERE nombre=?");
            st.setString(1, ag.getNombre());
            ResultSet rs = st.executeQuery();
            rs.next();
            ag.setId(rs.getInt("id_agricultores"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ObservableList<Agricultor> getAgricultores(){
        ObservableList<Agricultor> agricultorr= FXCollections.observableArrayList();
        try {

            PreparedStatement st=conexion.prepareStatement("SELECT * FROM agricultores");
            ResultSet rs=st.executeQuery();

            while(rs.next()){

                Agricultor auxiliarAgricultor = new Agricultor();
                auxiliarAgricultor.setId(rs.getInt("id_agricultores"));
                auxiliarAgricultor.setNombre(rs.getString("nombre"));
                auxiliarAgricultor.setDni(rs.getString("dni"));
                auxiliarAgricultor.setDireccion(rs.getString("direccion"));
                agricultorr.add(auxiliarAgricultor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agricultorr;
    }


    public  void modificarAgricultor(Agricultor ag){
        try{
            PreparedStatement ps=conexion.prepareStatement("UPDATE agricultores SET nombre=?, dni=?, direccion=? WHERE id_agricultores=?");
            ps.setString(1, ag.getNombre());
            ps.setString(2, ag.getDni());
            ps.setString(4, ag.getDireccion());
            ps.setInt(5, ag.getId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void modificarMasAvanzado(String cambio, String valor, int id){
        try{
            PreparedStatement ps=conexion.prepareStatement("UPDATE agricultores SET "+ cambio +" = ? WHERE id_agricultores=?");
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void borrarAgricultor(int idAgricultor){

        try{
            PreparedStatement ps=conexion.prepareStatement("DELETE FROM agricultores WHERE id_agricultores=?");
            ps.setInt(1, idAgricultor);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
