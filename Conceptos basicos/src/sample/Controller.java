package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField textEdad;
    @FXML Label lbTitulo;
    public void evento1(ActionEvent event){
        int dias =Integer.parseInt(textEdad.getText())*365;
        lbTitulo.setText("has vivido "+dias+" dias");
    }
}
