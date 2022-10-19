package com.example.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListaDeLaCompra {

    private ArrayList<String> lista;
    private String archivo = "C:/Users/Rentadvisor/Documents/Freelance/Exceptions/listaDeCompra.txt";
    public ListaDeLaCompra(String filename) throws IOException {
        cargarLista(filename);
    }

    private void cargarLista(String filename) throws IOException {
            lista = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
    }

    public String obtenerElemento(int indice)
    {
        if (indice < lista.size()){
            return lista.get(indice);
        }else {
            return "Elemento no encontrado";
        }

    }

    public void insertarElemento(String elemento) throws IOException {

        FileWriter fstream = new FileWriter(archivo, true);

        // Se usa Out como recurso para el TRY.
        // Un recurso es un objeto que debe ser cerrado cuando se ha terminado de usar.
        // El try se encargará de cerrar los recursos después de usarlos en el try
        try (BufferedWriter out = new BufferedWriter(fstream)){
            out.close();
            out.write("\n"+elemento);
            cargarLista(archivo);
            System.out.println("Bloque try ejecutado por completo");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Bloque Cath ejecutado por completo");
        }
        finally {
            if (out != null){
                out.close();
            }
            System.out.println("Bloque Finally ejecutado por completo");
        }

    }
}
