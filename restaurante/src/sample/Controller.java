package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller {
   @FXML TextField txtusuario;
   @FXML PasswordField txtpassworl;


    public void login (ActionEvent event){
ingresar();
    }
    public void enter(KeyEvent event){
        if (event.getCode()== KeyCode.ENTER){
            ingresar();

        }
    }
    public void ingresar(){
        String u=txtusuario.getText();
        String p=txtpassworl.getText();
        if(u.equals("Insanity")&& p.equals("12345678")){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Pantallacobro.fxml"));

                Scene scene = new Scene(root);
                Main.stage.setScene(scene);
                Main.stage.setHeight(430);
                Main.stage.setWidth(750);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Music Store");
            alert.setContentText("Datos Invalidos");
            alert.show();

        }
    }
    public void contra(ActionEvent event){
        Alert AlertType = new Alert(Alert.AlertType.INFORMATION);
        AlertType.setTitle("Contraseña");
        AlertType.setContentText("Usuario: Insanity \nContraseña: 12345678");
        AlertType.initStyle(StageStyle.UTILITY);
        AlertType.show();
    }
}
