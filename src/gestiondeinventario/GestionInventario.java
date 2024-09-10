package gestiondeinventario;

import java.util.Scanner;

/**
 *
 * @author Luisa Lucio & Valentina Rubio
 */

class Producto {
    String name;
    Producto sgt;

    public Producto(String nombre) {
        this.name = nombre;
        this.sgt = null;
    }
}

class Inventario {
    private Producto cabeza;

    public Inventario() {
        this.cabeza = null;
    }

    public void agregarProducto(String name) {
        Producto neww = new Producto(name);
        if (cabeza == null) {
            cabeza = neww;
        } else {
            Producto temp = cabeza;
            while (temp.sgt != null) {
                temp = temp.sgt;
            }
            temp.sgt = neww;
        }
        System.out.println("Producto agregado: " + name);
    }

    public void eliminarProducto(String name) {
        if (cabeza == null) {
            System.out.println("El inventario está vacío!");
            return;
        }
        if (cabeza.name.equals(name)) {
            cabeza = cabeza.sgt;
            System.out.println("Producto eliminado: " + name);
            return;
        }
        Producto actual = cabeza;
        while (actual.sgt != null && !actual.sgt.name.equals(name)) {
            actual = actual.sgt;
        }
        if (actual.sgt == null) {
            System.out.println("Producto no encontrado!");
        } else {
            actual.sgt = actual.sgt.sgt;
            System.out.println("Producto eliminado: " + name);
        }
    }

   
    public void mostrarInventario() {
        if (cabeza == null) {
            System.out.println("El inventario está vacío!");
            return;
        }
        Producto temp = cabeza;
        System.out.println("Inventario:");
        while (temp != null) {
            System.out.println("- " + temp.name);
            temp = temp.sgt;
        }
    }
}

public class GestionInventario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario in = new Inventario();

        int p;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar nuevo producto al inventario");
            System.out.println("2. Eliminar producto por nombre");
            System.out.println("3. Mostrar lista completa de productos");
            System.out.println("4. Salir del menú");
            System.out.print("\nElija una opción: ");
            p = sc.nextInt();
            sc.nextLine();

            switch (p) {
                case 1:
                    System.out.print("Ingrese nombre del producto: ");
                    String name = sc.nextLine();
                    in.agregarProducto(name);
                    break;

                case 2:
                    System.out.print("Ingrese nombre del producto a eliminar: ");
                    String nameEliminar = sc.nextLine();
                    in.eliminarProducto(nameEliminar);
                    break;

                case 3:
                    in.mostrarInventario();
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no encontrada!");
            }

        } while (p != 4);

        sc.close();
    }
}

