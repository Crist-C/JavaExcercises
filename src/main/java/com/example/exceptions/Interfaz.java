package com.example.exceptions;

import java.io.IOException;
import java.util.Scanner;

public class Interfaz {

    private ListaDeLaCompra listaDeLaCompra;

    public Interfaz(String archivo){
        try {
            listaDeLaCompra = new ListaDeLaCompra(archivo);
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Ha ocurrido un error con la lectura del archivo: "+e.getMessage());
            //throw new RuntimeException(e);
        }
    }


    public void mostrarMenu(){

        Scanner scanner = new Scanner(System.in);
        int opcionElegida;

        do{
            System.out.println("Para salir introduzca 0");
            System.out.println("Para ver un elemento introduzca la posición del elemento");
            System.out.println("Para añadir un elemento introduzca -1");
            opcionElegida = scanner.nextInt();
            if (opcionElegida != 0 && opcionElegida != -1){
                mostrarElemento(opcionElegida);
            }
            if (opcionElegida == -1){
                System.out.println("Que elemento desea añadir?");
                String nuevoElemento = scanner.next();
                try {
                    listaDeLaCompra.insertarElemento(nuevoElemento);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }while (opcionElegida != 0);


    }

    private void mostrarElemento(int indice){
        System.out.println("El elemento numero "+ indice+ " de la lista es "+listaDeLaCompra.obtenerElemento(indice));
    }

}
