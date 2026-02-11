import java.util.Scanner;

class Persona {
    int id;
    String nombre;
    boolean activa;

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.activa = true;
    }
}

public class GestionPersonas {
    static Persona[] personas = new Persona[20];
    static int contador = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion(0, 5);

            switch (opcion) {
                case 1:
                    alta();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    bajaLogica();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    actualizar();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
            }
        } while (opcion != 0);
    }

    static int leerOpcion(int min, int max) {
        int entrada = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print("Seleccione una opción (" + min + "-" + max + "): ");
            String input = sc.nextLine();

            try {
                entrada = Integer.parseInt(input);
                if (entrada >= min && entrada <= max) {
                    valido = true;
                } else {
                    System.out.println("Error: Opción fuera de rango. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor numérico entero.");
            }
        }
        return entrada;
    }

    static void mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE PERSONAS ---");
        System.out.println("1) Alta");
        System.out.println("2) Buscar por ID (Solo activas)");
        System.out.println("3) Baja lógica por ID");
        System.out.println("4) Listar activas");
        System.out.println("5) Actualizar nombre por ID");
        System.out.println("0) Salir");
    }

    static void alta() {
        if (contador >= personas.length) {
            System.out.println("Error: No hay espacio en el arreglo.");
            return;
        }

        System.out.print("Ingrese ID (Debe ser > 0): ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
            if (id <= 0) {
                System.out.println("Error: El ID debe ser mayor a 0.");
                return;
            }
            if (buscarIndicePorId(id) != -1) {
                System.out.println("Error: Este ID ya existe.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: ID inválido.");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        personas[contador++] = new Persona(id, nombre);
        System.out.println("Persona registrada con éxito.");
    }

    static void buscar() {
        System.out.print("ID a buscar: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            int index = buscarIndicePorId(id);
            if (index != -1 && personas[index].activa) {
                System.out.println("Persona encontrada: " + personas[index].nombre);
            } else {
                System.out.println("Error: Persona no encontrada o está inactiva.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    static void bajaLogica() {
        System.out.print("ID para dar de baja: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            int index = buscarIndicePorId(id);
            if (index != -1 && personas[index].activa) {
                personas[index].activa = false;
                System.out.println("Baja realizada correctamente.");
            } else {
                System.out.println("No se pudo realizar la baja: ID no encontrado o ya inactivo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    static void listar() {
        System.out.println("\n--- LISTADO DE ACTIVAS ---");
        boolean hay = false;
        for (int i = 0; i < contador; i++) {
            if (personas[i].activa) {
                System.out.println("ID: " + personas[i].id + " | Nombre: " + personas[i].nombre);
                hay = true;
            }
        }
        if (!hay)
            System.out.println("No hay personas activas.");
    }

    static void actualizar() {
        System.out.print("ID para actualizar nombre: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            int index = buscarIndicePorId(id);
            if (index != -1 && personas[index].activa) {
                System.out.print("Nuevo nombre: ");
                String nuevo = sc.nextLine();
                if (!nuevo.trim().isEmpty()) {
                    personas[index].nombre = nuevo;
                    System.out.println("Nombre actualizado.");
                } else {
                    System.out.println("Nombre no válido.");
                }
            } else {
                System.out.println("Persona no encontrada o inactiva.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    static int buscarIndicePorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id)
                return i;
        }
        return -1;
    }
}