package genericos;

public class Utilidades {
/**
 *  Optaremos por usar genéricos cuando tengamos códigos que puede
 *  ser usado por diferentes tipos de datos.
 *
 *  El tipo T puede ser usado durante el ambito del método de una clase mas
 *  no desde otro método de la misma clase.
 *
 * */
    public static <T> int contadorListaAparicions(T[] lista, T objeto){
        int count = 0;

        for (T objetoLista : lista)
        {
            objetoLista.equals(objeto);
            count++;
        }


        return count;
    }

    void otroMetodo(){

    }


}
