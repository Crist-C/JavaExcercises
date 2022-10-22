package genericos;

import java.util.ArrayList;

public class Main {

    /**
     *  tipos genéricos:
     *  T: Tipos
     *  E: Elementos
     *  K: Claves
     *  N: Números
     *  V: Valores
     *  Para mas de un tipo podemos usar S, U...etc.
     *
     * */

    public static void main(String[] args)
    {
        //EjemploGenericos();
        EjemploWildCards();
    }

    private static void EjemploWildCards() {

        Object miObject = new Object();
        Integer miInteger = 5;

        miObject = miInteger;
        Number miNumber = miInteger;

        ArrayList<Number> lista = new ArrayList<>();
        lista.add(miInteger);
        lista.add(miNumber);

        mostrarListaTipoNumber(lista);

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(miInteger);

        mostrarLista(lista2);
    }

    /**
     * Este método recibe un array de tipo Number
     * */
    private static void mostrarListaTipoNumber(ArrayList<Number> lista) {
        for (Number number : lista) {
            System.out.println(number);
        }
    }

    /**
     * Este método recibe un array de objetos que extiendan de la clase Number
     * es decir también recibe Arralist de tipo Integer
     * */
    private static void mostrarLista(ArrayList<? extends Number> lista) {
        for (Number ObjectLista :
                lista) {
            System.out.println(ObjectLista.toString());
        }
    }

    /**
     * Este método recibe un array de objetos que sean clases padre de Integer
     * es decir también recibe Arralist de tipo Integer, Number u Objects, sin embargo
     * para acceder a cada elemento de la lista se debe usar un objeto de la clase padre
     * en este caso Object, ya que Integer extiende de Number y éste a su vez extiende de Object.
     * */
    private static void mostrarListaTipoSuperInteger(ArrayList<? super Integer> lista)
    {
        for (Object objeto :
                lista) {
            System.out.println(objeto);
        }
    }


    private static void EjemploGenericos(){

        // Ejemplo caja con parámetro tipo Object
        Caja caja = new Caja();
        caja.setObject(55);
        // En este caso no genera ningún error en tiempo de compilación pero si se presentará
        // en tiempo de ejecución
        String datoCaja = (String) caja.getObject();

        // Ejemplo caja con parámetro tipo Genérico
        CajaGenerica<Integer> cajaGenerica = new CajaGenerica<>();
        cajaGenerica.setObject(55);
        // En este caso genera un error en tiempo de compilación y no en tiempo de ejecución
        // String datoCajaGenerica = (String) cajaGenerica.getObject();



    }




}
