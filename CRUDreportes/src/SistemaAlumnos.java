import java.util.Scanner;

public class SistemaAlumnos {

    Alumno[] alumnos = new Alumno[25];
    int contador = 0;
    Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("\n--- GESTIÓN DE ALUMNOS ---");
        System.out.println("1) Alta alumno");
        System.out.println("2) Buscar por ID (solo activos)");
        System.out.println("3) Actualizar promedio");
        System.out.println("4) Baja lógica");
        System.out.println("5) Listar activos");
        System.out.println("6) Reportes");
        System.out.println("0) Salir");
        return leerOpcion(0, 6);
    }

    private int leerOpcion(int min, int max) {
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
                    System.out.println("Opción fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }
        return entrada;
    }

    public void alta() {
        if (contador >= alumnos.length) {
            System.out.println("No hay espacio.");
            return;
        }

        try {
            System.out.print("ID (>0): ");
            int id = Integer.parseInt(sc.nextLine());

            if (id <= 0) {
                System.out.println("ID inválido.");
                return;
            }

            if (buscarIndicePorId(id) != -1) {
                System.out.println("ID repetido.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            if (nombre.trim().isEmpty()) {
                System.out.println("Nombre vacío.");
                return;
            }

            System.out.print("Promedio (0-10): ");
            double promedio = Double.parseDouble(sc.nextLine());

            if (promedio < 0 || promedio > 10) {
                System.out.println("Promedio inválido.");
                return;
            }

            alumnos[contador++] = new Alumno(id, nombre, promedio);
            System.out.println("Alumno registrado.");

        } catch (NumberFormatException e) {
            System.out.println("Datos inválidos.");
        }
    }

    public void buscar() {
        try {
            System.out.print("ID a buscar: ");
            int id = Integer.parseInt(sc.nextLine());
            int index = buscarIndicePorId(id);

            if (index != -1 && alumnos[index].activo) {
                System.out.println("Alumno: " + alumnos[index].nombre +
                        " | Promedio: " + alumnos[index].promedio);
            } else {
                System.out.println("No encontrado o inactivo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    public void actualizarPromedio() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            int index = buscarIndicePorId(id);

            if (index != -1 && alumnos[index].activo) {
                System.out.print("Nuevo promedio: ");
                double nuevo = Double.parseDouble(sc.nextLine());

                if (nuevo < 0 || nuevo > 10) {
                    System.out.println("Promedio inválido.");
                    return;
                }

                alumnos[index].promedio = nuevo;
                System.out.println("Promedio actualizado.");
            } else {
                System.out.println("Alumno no encontrado o inactivo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Dato inválido.");
        }
    }

    public void bajaLogica() {
        try {
            System.out.print("ID para baja: ");
            int id = Integer.parseInt(sc.nextLine());
            int index = buscarIndicePorId(id);

            if (index != -1 && alumnos[index].activo) {
                alumnos[index].activo = false;
                System.out.println("Baja realizada.");
            } else {
                System.out.println("No encontrado o ya inactivo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    public void listar() {
        System.out.println("\n--- ACTIVOS ---");
        boolean hay = false;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].activo) {
                System.out.println("ID: " + alumnos[i].id +
                        " | Nombre: " + alumnos[i].nombre +
                        " | Promedio: " + alumnos[i].promedio);
                hay = true;
            }
        }

        if (!hay)
            System.out.println("No hay alumnos activos.");
    }

    public void reportes() {
        double suma = 0;
        int activos = 0;
        Alumno mayor = null;
        Alumno menor = null;
        int excelentes = 0;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].activo) {
                double prom = alumnos[i].promedio;
                suma += prom;
                activos++;

                if (mayor == null || prom > mayor.promedio)
                    mayor = alumnos[i];

                if (menor == null || prom < menor.promedio)
                    menor = alumnos[i];

                if (prom >= 8.0)
                    excelentes++;
            }
        }

        if (activos == 0) {
            System.out.println("No hay alumnos activos.");
            return;
        }

        System.out.println("Promedio general: " + (suma / activos));
        System.out.println("Mayor promedio: " + mayor.id + " - " + mayor.nombre + " | " + mayor.promedio);
        System.out.println("Menor promedio: " + menor.id + " - " + menor.nombre + " | " + menor.promedio);
        System.out.println("Alumnos con promedio >= 8: " + excelentes);
    }

    private int buscarIndicePorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].id == id)
                return i;
        }
        return -1;
    }
}
