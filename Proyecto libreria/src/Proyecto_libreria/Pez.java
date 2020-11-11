package Proyecto_libreria;

public class Pez {
    public String Por_nacimiento;
    public String Tipo_pez;

    public Pez(String por_nacimiento, String Tipo_pez) {
        Por_nacimiento = por_nacimiento;
        Por_nacimiento = Tipo_pez;
    }

    public Pez() {

    }

    public String Por_nacimiento(double numero){
        double cant=.90;

        numero = numero * cant;


        return numero+"";

    }



    public String Tipo_pez(String nombre) {
        return nombre;
    }
}