package com.weatherapp.javaFXapplication;

import com.weatherapp.dataBaseDao.LocalizationDao;
import com.weatherapp.dataBaseDao.LocalizationDaoImpl;
import com.weatherapp.model.Localization;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField kraj;
    @FXML
    private TextField region;
    @FXML
    private TextField miejscowosc;
    @FXML
    private TextField dlgeo;
    @FXML
    private TextField szergeo;
    @FXML
    private TextField miejscowosc1;
    @FXML
    private TextField temperatura;
    @FXML
    private TextField cisnienie;
    @FXML
    private TextField wilgotnosc;
    @FXML
    private TextField kierunekwiatru;
    @FXML
    private TextField predkoscwiatru;

    public void goToAddLocationView() {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("addLocationView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj nową lokalizację");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToShowForecast() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("showWeatherView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Pogoda");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addLocationButton() {
        LocalizationDao localizationDao = new LocalizationDaoImpl();
        Localization location = new Localization();
        boolean correct = true;
        if (kraj.getText().isBlank() || kraj.getText().equals("Pole nie może być puste")) {
            correct = false;
            kraj.setText("Pole nie może być puste");
        }
        if (miejscowosc.getText().isBlank() || miejscowosc.getText().equals("Pole nie może być puste")) {
            correct = false;
            miejscowosc.setText("Pole nie może być puste");
        }
        correct = validateLongitude(correct);
        correct = validateLatitude(correct);
        if (correct == true) {
            location.setCountry(kraj.getText());
            location.setRegion(region.getText());
            location.setName(miejscowosc.getText());
            location.setLongitude(Double.parseDouble(dlgeo.getText()));
            location.setLatitude(Double.parseDouble(szergeo.getText()));
            localizationDao.save(location);
        }
    }

    private boolean validateLongitude(boolean correct) {
        if (dlgeo.getText().isBlank() || dlgeo.getText().equals("Pole nie może być puste")) {
            correct = false;
            dlgeo.setText("Pole nie może być puste");
        }
        else if (dlgeo.getText().matches("^[a-zA-Z]+$")) {
            correct = false;
            dlgeo.setText("Podaj liczbę -180 - 180");
        }
        else {
            try {
                if (Double.parseDouble(dlgeo.getText()) < -180d || Double.parseDouble(dlgeo.getText()) > 180d) {
                    correct = false;
                    dlgeo.setText("Podaj liczbę -180 - 180");
                }
            } catch (NumberFormatException e) {
                dlgeo.setText("Podaj liczbę -180 - 180");
            }
        }
        return correct;
    }

    private boolean validateLatitude(boolean correct) {
        if (szergeo.getText().isBlank() || szergeo.getText().equals("Pole nie może być puste")) {
            correct = false;
            szergeo.setText("Pole nie może być puste");
        }
        else if (szergeo.getText().matches("^[a-zA-Z]+$")) {
            correct = false;
            szergeo.setText("Podaj liczbę -90 - 90");
        }
        else {
            try {
                if (Double.parseDouble(szergeo.getText()) < -90d || Double.parseDouble(szergeo.getText()) > 90d) {
                    correct = false;
                    szergeo.setText("Podaj liczbę -90 - 90");
                }
            } catch (NumberFormatException e) {
                szergeo.setText("Podaj liczbę -90 - 90");
            }
        }
        return correct;
    }
}


