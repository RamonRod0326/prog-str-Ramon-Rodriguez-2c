public class Main {
    public static void main(String[] args) {
        SistemaAlumnos sistema = new SistemaAlumnos();
        int opcion;

        do {
            opcion = sistema.menu();

            switch (opcion) {
                case 1:
                    sistema.alta();
                    break;
                case 2:
                    sistema.buscar();
                    break;
                case 3:
                    sistema.actualizarPromedio();
                    break;
                case 4:
                    sistema.bajaLogica();
                    break;
                case 5:
                    sistema.listar();
                    break;
                case 6:
                    sistema.reportes();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 0);
    }
}
