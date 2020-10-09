package sample;

import Conversiones.Conversion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField textEdad;
    @FXML Label lbTitulo;
    public void evento1(ActionEvent event){
        Conversion td = new Conversion();

        int numero =Integer.parseInt(textEdad.getText());
        String res=td.binario(numero);
        lbTitulo.setText(res);
    }
}
