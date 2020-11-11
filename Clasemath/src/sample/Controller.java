package sample;

import Calculos.Calculos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller {
    @FXML TextField txtArreglo1;
    @FXML TextField txtArreglo2;
    @FXML ListView Lista1;
    @FXML ListView Lista2;
    double[] areglo1=new double[5];
    double[][] areglo2=new double[2][4];
    int cont=0;
    int cont2=0;
    int cont3=0;
    public void procesar1(ActionEvent event){
        Calculos calculos= new Calculos(areglo1,areglo2);
         double[] res = calculos.procesarCoseno();
         for (double dato:res){
             Lista1.getItems().add(dato+"");
         }

    }
    public void procesar2(ActionEvent event){
        Calculos calculos= new Calculos(areglo1,areglo2);
        double[][] res = calculos.procesarSeno();
        for (int x=0;x<res.length;x++){
            String columna = "";
            for (int y=0;y<res[x].length;y++) {
                columna=columna+res[x][y]+". ";
            }
            Lista2.getItems().add(columna);
            }
    }
    public void Insertar1(ActionEvent event){
        if (cont<5) {
            double dato = Double.parseDouble(txtArreglo1.getText());
            areglo1[cont] = dato;
            cont++;
            txtArreglo1.setText("");
            imprimirArreglo(areglo1);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Arreglo lleno");
            alert.show();
        }
    }
    public void Insertar2(ActionEvent event){
        if (cont2<2) {
            double dato = Double.parseDouble(txtArreglo2.getText());
            areglo2[cont2][cont3] = dato;
            cont3++;
            if (cont3==4) {
                cont3=0;
                cont2++;
            }

            txtArreglo2.setText("");
            imprimirArreglobidi(areglo2);

        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Arreglo lleno");
            alert.show();
        }
    }
public void imprimirArreglo(double[] arr){
        for (int x=0;x<arr.length;x++){
            System.out.print(arr[x]+",");
        }
    System.out.println("");
}
public void imprimirArreglobidi(double[][] arr){
        for (int x=0;x<arr.length;x++){
            for (int y=0;y<arr[x].length;y++){
                System.out.print(arr[x][y]+",");
            }
            System.out.println("");
        }
    System.out.println("----------------------------------");
}
}
