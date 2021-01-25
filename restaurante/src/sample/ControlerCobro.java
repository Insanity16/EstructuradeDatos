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
import sample.Estructura.Busqueda;
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
    @FXML Label txtnombreusuario;
    @FXML TextField txtxventas;
    @FXML TextField txtprecio;
    int[] ventas=new int[5];


    LinkedList<String> lista=new LinkedList<>();
TableColumn columnintrumentos= new TableColumn("Nombre: ");
TableColumn canintrumentos= new TableColumn("Cantidad: ");
ObservableList<pedido> listapedidos= FXCollections.observableArrayList();
Queue<ListaPedidos> cola=new LinkedList<>();
Stack<ListaPedidos> pila= new Stack<>();
String [][] Intrumentosarray={
        {"Guitarra acústica","700",},
        {"Guitarra eléctrica","17500",},
        {"Piano","5000",},
        {"Trompeta","2500",},
        {"Batería","11700",},
        {"Bajo Eléctrico","2700",},
        {"Acordeón","8800",},
        {"Ukelele","500",},
        {"Melódica","450",},
};

int [] Precios={700,17500,5000,2500,11700,2700,8800,500,450};
//ejemplo para la busqueda binaria
    //String [] IntrumentosA=
            //{"Guitarra acústica","Guitarra eléctrica","Piano","Trompeta","Batería","Bajo Eléctrico","Acordeón"
            //,"Ukelele","Melódica"};
           //intente usar el otro arreglo pero no pude al final xd
           //lo logre la verdad nose como pero ya esta
    @FXML  protected void initialize(){
        txtnombreusuario.setText(Main.NombreU);
        columnintrumentos.setCellValueFactory(new PropertyValueFactory<pedido,String>("Instrumentos"));
        canintrumentos.setCellValueFactory(new PropertyValueFactory<pedido,String>("Cantinstrumentos"));

        Tabla.getColumns().addAll(columnintrumentos,canintrumentos);
        Tabla.setItems(listapedidos);
/*
        lista.add("Guitarra acústica");
        lista.add("Guitarra eléctrica");
        lista.add("Piano");
        lista.add("Trompeta");
        lista.add("Batería");
        lista.add("Bajo Eléctrico");
        lista.add("Acordeón");
        lista.add("Ukelele");
        lista.add("Melódica");
        */
        for (int x=0;x<Intrumentosarray.length;x++) {
        lista.add(Intrumentosarray[x][0]);
        }

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
    int cont=0;
public void Insertarventas(ActionEvent event){
    ventas[cont]=Integer.parseInt(txtxventas.getText().toString());
            cont++;

}
    public void ordenarventas(ActionEvent event) {
        Busqueda ordenar=new Busqueda();
        int[] ordenado= ordenar.burbuja(ventas);

    }
    public void Ordenarxprecio(ActionEvent event){
    Busqueda ordenar= new Busqueda();
    listview_instrumentos.getItems().clear();
    lista.clear();
    String [][] ordenado =ordenar.burbujaarray(Intrumentosarray);
    for (int x=0;x<ordenado.length;x++){
       lista.add(ordenado[x][0]);
       listview_instrumentos.getItems().add(ordenado[x][0]);


        }
    }
    public void ordenarxnombre(ActionEvent event) {
        /*Busqueda alfa = new Busqueda();
        listview_instrumentos.getItems().clear();
        lista.clear();
        String[] alfa2 = alfa.alfabeto(IntrumentosA);
        for (int x = 0; x < alfa2.length; x++) {
            lista.add(alfa2[x]);
            listview_instrumentos.getItems().add(alfa2[x]);
            ESTE ERA PARTE DEL OTRO ARREGLO PERO AL FINAL SI PUDE USAR EL BINARIO uwu
*/
        Busqueda alfa = new Busqueda();
        listview_instrumentos.getItems().clear();
        lista.clear();
        String[][] alfa2 = alfa.burbujaarrayalfa(Intrumentosarray);
        for (int x = 0; x < alfa2.length; x++) {
            lista.add(alfa2[x][0]);
            listview_instrumentos.getItems().add(alfa2[x][0]);
        }
    }
    public void Buscarxprecio(ActionEvent event) {
        int precio;
        Busqueda ordenar=new Busqueda();
        int[] ordenado= ordenar.burbuja(Precios);
        precio=Integer.parseInt(txtprecio.getText());
        Busqueda bi= new Busqueda();
        int busca=bi.binario(Precios,precio);

        if (busca==0){
            Image image1 = new Image("./sample/img/GuitarEl.jpg");
            immm.setImage(image1);

        }
        if (busca==1){
            Image image1 = new Image("./sample/img/bateria.jpg");
            immm.setImage(image1);

        }
        if (busca==2){
            Image image1 = new Image("./sample/img/acordeon.jpg");
            immm.setImage(image1);

        }
        if (busca==3){
            Image image1 = new Image("./sample/img/Piano.jpg");
            immm.setImage(image1);

        }
        if (busca==4){
            Image image1 = new Image("./sample/img/bajo.jpg");
            immm.setImage(image1);

        }
        if (busca==5){
            Image image1 = new Image("./sample/img/Trompeta.jpg");
            immm.setImage(image1);

        }
        if (busca==6){
            Image image1 = new Image("./sample/img/guitarAc.jpg");
            immm.setImage(image1);

        }
        if (busca==7){
            Image image1 = new Image("./sample/img/ukelele.jpg");
            immm.setImage(image1);

        }
        if (busca==8){
            Image image1 = new Image("./sample/img/melodica.jpg");
            immm.setImage(image1);

        }if(busca==-1) {
            Alert AlertType = new Alert(Alert.AlertType.INFORMATION);
            AlertType.setTitle("Alert");
            AlertType.setContentText("No tenemos ese precio en nuestros productos");
            AlertType.initStyle(StageStyle.UTILITY);
            AlertType.show();
        }

    }

}
