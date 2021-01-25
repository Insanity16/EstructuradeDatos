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
import sample.Estructura.Busqueda;

import java.io.IOException;

public class Controller {
   @FXML TextField txtusuario;
   @FXML PasswordField txtpassworl;
   String [][] arrayUsarios=new String[3][3];
   @FXML protected void initialize(){
       arrayUsarios[0][0]="Saul Rodriguez";arrayUsarios[0][1]="admin";arrayUsarios[0][2]="12345678";
       arrayUsarios[1][0]="Administrador 2";arrayUsarios[1][1]="admin2";arrayUsarios[1][2]="12345678";
       arrayUsarios[2][0]="Eren jeagar";arrayUsarios[2][1]="Eren";arrayUsarios[2][2]="12345678";
   }

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
        Busqueda busqueda=new Busqueda();
        int indice=busqueda.secuencial(arrayUsarios,u,p);
        if(indice >= 0){
            try {
                Main.NombreU=arrayUsarios[indice][0];
                Parent root = FXMLLoader.load(getClass().getResource("Pantallacobro.fxml"));

                Scene scene = new Scene(root);
                Main.stage.setScene(scene);
                Main.stage.setHeight(450);
                Main.stage.setWidth(680);
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
        AlertType.setContentText("Usuario: Eren \nContraseña: 12345678");
        AlertType.initStyle(StageStyle.UTILITY);
        AlertType.show();
    }
}
