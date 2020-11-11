package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import Paquete_pez.Pez;



public class Controller {
    @FXML TextField txt1;
    @FXML ListView list;
    @FXML ComboBox comboBox;
    @FXML
    public void initialize() {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Trucha", "Carpa");

    }


    Pez pez=new Pez();
    String [] Peces= new String[3];




//list.getItems().add(res);


    public void insertar(ActionEvent event) {

        if(txt1.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Alert!!!");
            alert.setContentText("Rellena el campo restante!");
            alert.showAndWait();

        } else {
            double dato = Double.parseDouble(txt1.getText());
            double resto = (dato * .10);
            String Resto = String.valueOf(resto);
            String res = pez.Por_nacimiento(dato);


            Peces[0] = res;
            Peces[1] = String.valueOf(comboBox.getValue().toString());
            Peces[2] = Resto;

        }
    }
    public void procesar(ActionEvent event){
       // for  (int x=0; x<Trucha.length; x++){
            //list.getItems().add(res)
        double dato = Double.parseDouble(txt1.getText());
        list.getItems().add("Pescado "+Peces[1]+" nacen "+dato+" por cria y "+Peces[0]+" al año lo cual nos da una perdida de: "+Peces[2]);
        txt1.setText("");



    }

    public void salir(ActionEvent event){
        System.exit(0);


    }


}
