package com.umss.buscaminas.presentacion;

import com.umss.buscaminas.application.Casilla;
import com.umss.buscaminas.application.Tablero;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BuscaminasController {
    private Tablero tablero;
    private int tamanio;
    private int minas;

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize() {
        // Inicializar el juego con dificultad "medio"
        tamanio = 15;
        minas = 34;
        tablero = new Tablero(tamanio, minas);
        crearTablero();
    }

    private void crearTablero() {
        gridPane.getChildren().clear();
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Button button = new Button();
                button.setPrefSize(30, 30);
                final int fila = i;
                final int columna = j;
                button.setOnAction(e -> revelarCasilla(fila, columna));
                gridPane.add(button, j, i);
            }
        }
    }

    private void revelarCasilla(int fila, int columna) {
        tablero.revelarCasilla(fila, columna);
        actualizarTablero();
        if (!tablero.getEstado()) {
            System.out.println("PISASTE UNA MINA");
        } else if (tablero.verificarVictoria()) {
            System.out.println("¡GANASTE!");
        }
    }

    private void actualizarTablero() {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Button button = (Button) gridPane.getChildren().get(i * tamanio + j);
                Casilla casilla = tablero.getCasilla(i, j);
                if (casilla.estaRevelada()) {
                    if (casilla.esMina()) {
                        button.setText("X");
                    } else {
                        button.setText(String.valueOf(casilla.getMinasAlrededor()));
                    }
                    button.setDisable(true);
                } else if (casilla.esPosibleMina()) {
                    button.setText("P");
                } else {
                    button.setText("");
                }
            }
        }
    }

    @FXML
    private void reiniciarJuego() {
        tablero = new Tablero(tamanio, minas);
        crearTablero();
    }
}
