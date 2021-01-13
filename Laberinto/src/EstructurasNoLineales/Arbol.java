package EstructurasNoLineales;

public class Arbol {
    NodoArbol inicial;
    public Arbol(){
        this.inicial=null;
    }
    public void insertar(int valor){
        if(this.inicial== null) {
            this.inicial = new NodoArbol(valor);
        }else {
            this.inicial.insertar(valor);
        }
    }
    public void dispararPreorden(){
          this.preorder(this.inicial);
    }
    public void preorder(NodoArbol nodo){
        if(nodo==null) {
            return;
        }else{
            System.out.print(nodo.getValor()+", ");
            preorder(nodo.getNodoIzq());
            preorder(nodo.getNodoDer());

        }
    }
    public void dispararInorden(){
        this.inorden(this.inicial);
    }
    public void inorden(NodoArbol nodo){
        if(nodo==null) {
            return;
        }else{
            inorden(nodo.getNodoIzq());
            System.out.print(nodo.getValor()+", ");
            inorden(nodo.getNodoDer());

        }
    }
    public void dispararpostorden(){
        this.postorden(this.inicial);
    }
    public void postorden(NodoArbol nodo){
        if(nodo==null) {
            return;
        }else{
            postorden(nodo.getNodoIzq());
            postorden(nodo.getNodoDer());
            System.out.print(nodo.getValor()+", ");

        }
    }
}
