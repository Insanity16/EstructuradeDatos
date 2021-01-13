package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;
import sample.Estructura.ListaPedidos;
import sample.Estructura.pedido;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ControlerCobro {
    @FXML ListView listview_instrumentos;
    @FXML TableView Tabla;
    @FXML TextField txtCan;
    @FXML TextField txtnombre;
    @FXML Label nombrepedido;
    @FXML ImageView immm;
    LinkedList<String> lista=new LinkedList<>();
TableColumn columnintrumentos= new TableColumn("Nombre: ");
TableColumn canintrumentos= new TableColumn("Cantidad: ");
ObservableList<pedido> listapedidos= FXCollections.observableArrayList();
Queue<ListaPedidos> cola=new LinkedList<>();
Stack<ListaPedidos> pila= new Stack<>();


    @FXML  protected void initialize(){
        columnintrumentos.setCellValueFactory(new PropertyValueFactory<pedido,String>("Instrumentos"));
        canintrumentos.setCellValueFactory(new PropertyValueFactory<pedido,String>("Cantinstrumentos"));

        Tabla.getColumns().addAll(columnintrumentos,canintrumentos);
        Tabla.setItems(listapedidos);

        lista.add("Guitarra acústica");
        lista.add("Guitarra eléctrica");
        lista.add("Piano");
        lista.add("Trompeta");
        lista.add("Batería");
        lista.add("Bajo Eléctrico");
        lista.add("Acordeón");
        lista.add("Ukelele");
        lista.add("Melódica");
        for (int x=0;x<lista.size();x++)listview_instrumentos.getItems().add(lista.get(x));


    }
    public void Insertarpedido(ActionEvent event){
String I=listview_instrumentos.getSelectionModel().getSelectedItems().toString();
String canI= txtCan.getText();
listapedidos.add(new pedido(I,canI));
txtCan.setText("");
        //System.out.println(I);

        if (I.equals("[Guitarra acústica]")){
            Image image1 = new Image("./sample/img/guitarAc.jpg");
            immm.setImage(image1);

        }
        if (I.equals("[Guitarra eléctrica]")){
            Image image1 = new Image("./sample/img/GuitarEl.jpg");
            immm.setImage(image1);

        }
        if (I.equals("[Piano]")){
            Image image1 = new Image("./sample/img/Piano.jpg");
            immm.setImage(image1);

        }
        if (I.equals("[Trompeta]")){
            Image image1 = new Image("./sample/img/Trompeta.jpg");
            immm.setImage(image1);
        }
        if (I.equals("[Batería]")){
            Image image1 = new Image("./sample/img/bateria.jpg");
            immm.setImage(image1);

        }
        if (I.equals("[Bajo Eléctrico]")){
            Image image1 = new Image("./sample/img/bajo.jpg");
            immm.setImage(image1);

        }
        if (I.equals("[Acordeón]")){
            Image image1 = new Image("./sample/img/acordeon.jpg");
            immm.setImage(image1);

        }
        if (I.equals("[Ukelele]")){
            Image image1 = new Image("./sample/img/ukelele.jpg");
            immm.setImage(image1);

        }
        if (I.equals("[Melódica]")){
            Image image1 = new Image("./sample/img/melodica.jpg");
            immm.setImage(image1);

        }

    }
   public void Guardarpedido(ActionEvent event){
        String[][] items= new String[listapedidos.size()][4];
       for (int x=0;x<items.length;x++){
           items[x][0]=listapedidos.get(x).getInstrumentos();
           items[x][1]=listapedidos.get(x).getCantinstrumentos();
       }
       ListaPedidos pedido= new ListaPedidos(items,txtnombre.getText());
       cola.add(pedido);
       pila.add(pedido);
       listapedidos.clear();
       txtnombre.setText("");
    }
    public void finalizar (ActionEvent event){
ListaPedidos perdido= cola.poll();
nombrepedido.setText(perdido.getNombre());
String [][] datos=perdido.getDatos();


    }
    public void Status (ActionEvent event){
        ListaPedidos pedidos= pila.pop();
        String [][] datos=pedidos.getDatos();
        for (int x=0;x<datos.length;x++){
            Alert AlertType = new Alert(Alert.AlertType.INFORMATION);
            AlertType.setTitle("Status");
            AlertType.setContentText("Nombre: "+pedidos.getNombre()+" "+datos[x][0]+" "+datos[x][1]);
            AlertType.initStyle(StageStyle.UTILITY);
            AlertType.show();

        }


    }
}
