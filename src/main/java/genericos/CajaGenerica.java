package genericos;

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

public class CajaGenerica <T>{

    private T object;

    public void setObject(T object){ this.object = object; }

    T getObject(){ return object; }

}
