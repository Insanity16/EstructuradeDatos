package EstructurasNoLineales;

public class NodoArbol {
    private int valor;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDer;
    public NodoArbol(int valor){
        this.valor=valor;
        this.nodoDer=null;
        this.nodoIzq=null;

    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }
    public void setNodoIzq(NodoArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }
    public NodoArbol getNodoDer() {
        return nodoDer;
    }
    public void setNodoDer(NodoArbol nodoDer) {
        this.nodoDer = nodoDer;
    }
    public  void insertar (int _valor){
        if(_valor<this.valor){
            if (this.nodoIzq==null){
                this.nodoIzq=new NodoArbol(_valor);
            }else {
                this.nodoIzq.insertar(_valor);
            }
        }else {
            if (this.nodoDer==null) {
                this.nodoDer = new NodoArbol(_valor);
            }else {
                this.nodoDer.insertar(_valor);
            }
        }
    }
}
