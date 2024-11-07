package com.umss.buscaminas.presentacion;

import com.umss.buscaminas.application.Buscaminas;
import com.umss.buscaminas.application.Dificultad;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.Arrays;

public class MenuController {

    @FXML
    private ChoiceBox<String> choiceDificuldad;

    private Buscaminas buscaminas;

    ObservableList<String> dificultades = FXCollections.observableArrayList();

    @FXML
    void iniciarBuscaminas(ActionEvent event) {

    }

    @FXML
    public void initialize(){
        cargarDificultades();
        buscaminas = new Buscaminas();
    }

    private void cargarDificultades(){
        dificultades.clear();
        Arrays.stream(Dificultad.values()).forEach(
                dificultad -> dificultades.add(dificultad.getName())
        );
        choiceDificuldad.getItems().addAll(dificultades);
        choiceDificuldad.setValue(dificultades.stream().findFirst().orElse(""));
    }

}

