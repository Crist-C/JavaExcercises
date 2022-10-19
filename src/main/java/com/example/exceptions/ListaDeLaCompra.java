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
    private final String archivo = "C:/Users/Rentadvisor/Documents/Freelance/Exceptions/listaDeCompra.txt";
    public ListaDeLaCompra(String filename) throws IOException {
        cargarLista(filename);
    }

    private void cargarLista(String filename) throws IOException {
            lista = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
    }

    public String obtenerElemento(int indice) throws PositionException
    {
        try {
            return lista.get(indice);
        }catch (RuntimeException e){
            PositionException positionException = new PositionException("Posición fuera de los limites de esta lista");
            positionException.initCause(e);
            throw positionException;
        }

    }

    public void insertarElemento(String elemento) throws IOException {

        FileWriter fstream = new FileWriter(archivo, true);
        // Se usa Out como recurso para el TRY.
        // Un recurso es un objeto que debe ser cerrado cuando se ha terminado de usar.
        // El try se encargará de cerrar los recursos después de usarlos en el try
        try(BufferedWriter out = new BufferedWriter(fstream)) {
            out.write("\n"+elemento);
            cargarLista(archivo);
        }catch (IOException e){
            e.printStackTrace();
            throw e;
        }

    }
}
