package com.example.proyectoentradafrutasjavafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Pane pane;

    @FXML
    private Label lblNombreAg;

    @FXML
    private Label lblDniAg;

    @FXML
    private Label lblDireccionAg;

    @FXML
    private Label lblNombreFruta;

    @FXML
    private Label lblCalibreF;

    @FXML
    private Label lblVariedadFruta;

    @FXML
    private Label lblAgricultorEntrada;

    @FXML
    private Label lblFrutaEntrada;

    @FXML
    private Label lblVariedadEntrada;

    @FXML
    private Label lblKilosEntrada;

    @FXML
    private Label lblAg;

    @FXML
    private Label lblFruta;

    @FXML
    private Label lblEntrada;

    @FXML
    private Label lblFechaEntrada;

    @FXML
    private TextField txtNombreAg;

    @FXML
    private TextField txtKilos;

    @FXML
    private TextField txtDniAg;

    @FXML
    private TextField txtDireccionAg;

    @FXML
    private TextField txtNombreFruta;

    @FXML
    private TextField tFCalibre;

    @FXML
    private TextField txtVariedadFruta;

    @FXML
    private ComboBox <Agricultor> comboBoxInsertar;

    @FXML
    private ComboBox comboBoxVariedad;

    @FXML
    private ComboBox <Fruta> comboBoxFruta;

    @FXML
    private ComboBox comboBoxKilos;

    @FXML
    private Button btnInsertarAg;

    @FXML
    private Button btnInsertarFruta;

    @FXML
    private Button btnInsertarEntrada;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Tab tabPaneEntradaFruta;

    @FXML
    private Tab tabPaneFruta;

    @FXML
    private Tab tabPaneAg;

    @FXML
    private TabPane TabPane;

    @FXML
    private TableView<Agricultor> table1;

    @FXML
    private TableView<Fruta> table2;

    @FXML
    private TableView table3;

    @FXML
    private TableColumn<Agricultor, String> nombreAgAg;

    @FXML
    private TableColumn<Agricultor, String> dniAgAg;

    @FXML
    private TableColumn<Agricultor, String> direccionAgAg;

    @FXML
    private TableColumn<Fruta, String> NombreFrutaF;

    @FXML
    private TableColumn<Fruta,String> VariedadFrutaF;

    @FXML
    private TableColumn<Entrada, Integer>  nombreAgEntrada;

    @FXML
    private TableColumn<Entrada, Integer>  nombreFrutaEntrada;

    @FXML
    private TableColumn<Entrada, String>  variedadFrutaEntrada;

    @FXML
    private TableColumn<Entrada, String>  kilosFrutaEntrada;

    @FXML
    private TableColumn<Entrada, String>  fechaEntrada;

    @FXML
    private TableColumn<Fruta, Integer> idtableColum;

    @FXML
    private TableColumn<Fruta,String> CalibreFrutaF;



    RepositorioFrutas repositorioDeFruta;
    RepositorioAgricultores repositorioDeAgricultores;

    RepositorioEntradas repositorioDeEntradas;

    public void clicarEnLaTblaFruta(javafx.scene.input.MouseEvent evento){
        Fruta fruta = (Fruta) table2.getSelectionModel().getSelectedItem();

        txtNombreFruta.setText(String.valueOf(fruta.getNombreFruta()));
        txtVariedadFruta.setText(String.valueOf(fruta.getVariedad()));
        tFCalibre.setText(String.valueOf(fruta.getCalibre()));

    }

    public void clicarEnLaTblaEntrada(javafx.scene.input.MouseEvent evento){
        Entrada entrada = (Entrada) table3.getSelectionModel().getSelectedItem();

        comboBoxInsertar.setVisibleRowCount(((Entrada) table3.getSelectionModel().getSelectedItem()).getNombreAgricultor());
        //nombreAgEntrada.setText((String) comboBoxInsertar.getValue());
        //nombreFrutaEntrada.setText((String) comboBoxFruta.getValue());
        variedadFrutaEntrada.setText((String) comboBoxVariedad.getValue());
        kilosFrutaEntrada.setText(txtKilos.getText());
        fechaEntrada.setText(String.valueOf(datePicker.getValue()));

    }

    public void clicarEnLaTblaAgricultor(javafx.scene.input.MouseEvent evento){
        Agricultor agricultor = (Agricultor) table1.getSelectionModel().getSelectedItem();

        nombreAgAg.setText(String.valueOf(agricultor.getNombre()));
        dniAgAg.setText(String.valueOf(agricultor.getDni()));
        direccionAgAg.setText(String.valueOf(agricultor.getDireccion()));

    }
    public void mostrFruta(){
        ObservableList<Fruta> obsFruta = repositorioDeFruta.getFrutas();
        NombreFrutaF.setCellValueFactory(new PropertyValueFactory<Fruta, String>("nombreFruta"));
        VariedadFrutaF.setCellValueFactory(new PropertyValueFactory<Fruta, String>("variedad"));
        CalibreFrutaF.setCellValueFactory(new PropertyValueFactory<Fruta, String>("calibre"));
        idtableColum.setCellValueFactory(new PropertyValueFactory<Fruta, Integer>("id"));
        table2.setItems(obsFruta);
    }

    public void mostrAgricultores(){
        ObservableList<Agricultor> objetoAgricultor = repositorioDeAgricultores.getAgricultores();
        nombreAgAg.setCellValueFactory(new PropertyValueFactory<Agricultor, String>("nombre"));
        dniAgAg.setCellValueFactory(new PropertyValueFactory<Agricultor, String>("dni"));
        direccionAgAg.setCellValueFactory(new PropertyValueFactory<Agricultor, String>("direccion"));
        table1.setItems(objetoAgricultor);
    }

    public void mostrEntrada(){
        ObservableList<Entrada> entradass = repositorioDeEntradas.getEntradass();
        nombreAgEntrada.setCellValueFactory(new PropertyValueFactory<Entrada, Integer>("nombreAgricultor"));
        nombreFrutaEntrada.setCellValueFactory(new PropertyValueFactory<Entrada, Integer>("nombreFruta"));
        fechaEntrada.setCellValueFactory(new PropertyValueFactory<Entrada, String>("fecha"));
        kilosFrutaEntrada.setCellValueFactory(new PropertyValueFactory<Entrada, String>("kilos"));
        table3.setItems(entradass);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        repositorioDeFruta = new RepositorioFrutas();
        repositorioDeFruta.setConexion();
        repositorioDeEntradas = new RepositorioEntradas();
        repositorioDeEntradas.setConexion();
        mostrFruta();
        ObservableList<Fruta> observableLisDeFruta = repositorioDeFruta.getFrutas();
        mostrEntrada();

            comboBoxFruta.setItems(observableLisDeFruta);

        for (Fruta f : observableLisDeFruta){
            comboBoxVariedad.getItems().add(f.getVariedad());
        }
        repositorioDeAgricultores = new RepositorioAgricultores();
        repositorioDeAgricultores.setConexion();
        mostrAgricultores();
        ObservableList<Agricultor> observableLisDeAgricultores = repositorioDeAgricultores.getAgricultores();

            comboBoxInsertar.setItems(observableLisDeAgricultores);

    }

    public void onInsertarFruta() {
        Fruta frutaa = new Fruta();
        frutaa.setNombreFruta(txtNombreFruta.getText());
        frutaa.setVariedad(txtVariedadFruta.getText());
        frutaa.setCalibre(tFCalibre.getText());
        txtNombreFruta.clear();
        txtVariedadFruta.clear();
        tFCalibre.clear();
        repositorioDeFruta.insertarFruta(frutaa);
        mostrFruta();

    }

    public void onInsertarAgricultor() {
        Agricultor agricultor = new Agricultor();
        agricultor.setNombre(txtNombreAg.getText());
        agricultor.setDni(txtDniAg.getText());
        agricultor.setDireccion(txtDireccionAg.getText());
        txtNombreAg.clear();
        txtDniAg.clear();
        txtDireccionAg.clear();
        repositorioDeAgricultores.insertarAgricultorr(agricultor);
        mostrAgricultores();
    }

    public void onInsertarEntrada() {
        Entrada entrada = new Entrada();
        entrada.setNombreAgricultor(comboBoxInsertar.getSelectionModel().getSelectedItem().getId());
        entrada.setNombreFruta(comboBoxFruta.getSelectionModel().getSelectedItem().getId());
        entrada.setKilos(txtKilos.getText());
        entrada.setFecha(String.valueOf(datePicker.getValue()));
        txtKilos.clear();
        repositorioDeEntradas.insertarEntradaa(entrada);
        mostrEntrada();
    }
}