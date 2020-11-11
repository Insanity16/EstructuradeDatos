import Paquete_pez.Pez;
public class Main {



    public static void main(String[] args) {
        Pez  pez=new Pez();
        String res= pez.Por_nacimiento(100);
        String des= pez.Tipo_pez("" );
        System.out.println(res);
        System.out.println(des);
    }
}
