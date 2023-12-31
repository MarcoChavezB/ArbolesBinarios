public class Arbol {
    Nodo r;
    int level;

    public Arbol(){
        this.r = null;
        this.level = 0;
    }

    public void pOrden(Nodo n){
        if(n == null){
            return;
        }
        System.out.println(n.dato);
        pOrden(n.izq);
        pOrden(n.der);
    }


    public void inOrden(Nodo n){
        if(n == null){
            return;
        }
        inOrden(n.izq);
        System.out.println(n.dato);
        inOrden(n.der);
    }

    void posOrden(Nodo n){
        if(n == null){
            return;
        }
        posOrden(n.izq);
        posOrden(n.der);
        System.out.println(n.dato);
    }



    void borrar(){
        if(r == null){
            return;
        }
        postBorrar(r);
        r = null;
    }

    void postBorrar(Nodo n){
        if(n == null){
            return;
        }
        postBorrar(n.izq);
        postBorrar(n.der);
        n.izq = null;
        n.der = null;
    }





    Nodo add (Nodo n, int v){
        if(n == null){
            Nodo nodo = new Nodo();
            nodo.dato = v;
            return nodo;
        }

        if(v <= n.dato){
            n.izq = add(n.izq, v);
        }else{
            n.der = add(n.der, v);
        }
        return n;
    }


    void bucarMostrar(int v){
        if(r == null){
            System.out.println("Arbol vacio");
            return;
        }

        Nodo n = buscar(r, v, 1);
        if(n == null){
            System.out.println("Valor no encontrado");
        }
    }

    Nodo buscar(Nodo n, int v, int lev){
        if(r == null){
            System.out.println("Arbol vacio");
        }
        if(n == null){
            return null;

        }else if(n.dato == v){
            System.out.println("Valor encontrado en el nivel " + lev);
            return n;
        }else if(v < n.dato){
            return buscar(n.izq, v, lev + 1);
        }else{
            return buscar(n.der, v, lev + 1);
        }
    }





    Nodo remove(Nodo subR, int v){
        if(subR == null){
            return subR;
        }

        if(v < subR.dato){
            subR.izq = remove(subR.izq, v);
        }else if(v > subR.dato){
            subR.der = remove(subR.der, v);
        }else{
            //Nodo con un solo hijo o sin hijos
            if (subR.izq == null) {
                return subR.der;
            } else if (subR.der == null) {
                return subR.izq;
            }

            Nodo sucesor = nodoSiguiente(subR.izq);
            subR.dato = sucesor.dato;
            subR.izq = remove(subR.izq, sucesor.dato);
        }

        System.out.println("Se elimino el nodo");
        return subR;
    }


    Nodo nodoSiguiente(Nodo n){
        while (n.der != null){
            n = n.der;
        }
        return n;
    }

    void modificar(int v, int nV){
        if(r == null){
            return;
        }

        Nodo R = buscar(r, v, 1);
        if(R == null){
            System.out.println("No encontrado");
        }else{
            r = remove(r, v);
            r = add(r, nV);
            System.out.println("valor modificado");
        }
    }


    String showRaiz(){
        return r.toString();
    }
}
