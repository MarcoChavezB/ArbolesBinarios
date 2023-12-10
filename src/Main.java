import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        arbol.r =  arbol.add(arbol.r, 8);
        arbol.r =  arbol.add(arbol.r, 3);
        arbol.r =  arbol.add(arbol.r, 6);
        arbol.r =  arbol.add(arbol.r, 1);
        arbol.r =  arbol.add(arbol.r, 32);
        arbol.r =  arbol.add(arbol.r, 7);
        arbol.r =  arbol.add(arbol.r, 32);
        arbol.r =  arbol.add(arbol.r, 43);
        arbol.r =  arbol.add(arbol.r, 6);

        do {
            System.out.println("----- Menú Arbol -----");
            System.out.println("1. Agregar nodo");
            System.out.println("2. Buscar y mostrar nodo");
            System.out.println("3. Eliminar nodo");
            System.out.println("4. Mostrar Arbol");
            System.out.println("5. Modificar nodo");
            System.out.println("6. Borrar árbol");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor del nuevo nodo: ");
                    int nuevoValor = scanner.nextInt();
                    arbol.r = arbol.add(arbol.r, nuevoValor);
                    break;
                case 2:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    arbol.bucarMostrar(valorBuscar);
                    break;
                case 3:
                    System.out.print("Ingrese el valor a eliminar: ");
                    int valorEliminar = scanner.nextInt();
                    arbol.r = arbol.remove(arbol.r, valorEliminar);
                    break;
                case 4:
                    System.out.println("----- Seleccionar Orden -----");
                    if(arbol.r == null){
                        System.out.println("El arbol esta vacio [Inicialize el arbol antes de mostrarlo]");
                        break;
                    }

                    System.out.println("Como mostrar el arbol: ");
                    System.out.println("[1] Oden PreOrden ");
                    System.out.println("[2] Orden InOrden");
                    System.out.println("[3] Orden PostOrden");
                    System.out.print("Seleccion:");
                    int mostrar = scanner.nextInt();
                    switch (mostrar){
                        case 1:
                            System.out.println("Mostrando en Preorden:");
                            arbol.pOrden(arbol.r);
                            break;
                        case 2:
                            System.out.println("Mostrando en Inorden:");
                            arbol.inOrden(arbol.r);
                            break;
                        case 3:
                            System.out.println("Mostrando en Postorden:");
                            arbol.posOrden(arbol.r);
                            break;
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el valor a modificar: ");
                    int valorModificar = scanner.nextInt();
                    System.out.print("Ingrese el nuevo valor: ");
                    int nuevoValorModificar = scanner.nextInt();
                    arbol.modificar(valorModificar, nuevoValorModificar);
                    break;
                case 6:
                    arbol.borrar();
                    System.out.println("Árbol borrado con éxito.");
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 9);

        scanner.close();
    }

}