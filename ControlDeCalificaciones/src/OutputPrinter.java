public class OutputPrinter {

    public void imprimirReporte(
            String nombreAlumno,
            double parcialUno,
            double parcialDos,
            double parcialTres,
            double promedioParciales,
            int porcentajeAsistencia,
            boolean entregoProyecto,
            double calificacionFinal,
            String estadoFinal
    ) {
        System.out.println("\n----- REPORTE FINAL -----");
        System.out.println("Alumno: " + nombreAlumno);
        System.out.println("Parciales: "
                + parcialUno + ", "
                + parcialDos + ", "
                + parcialTres);
        System.out.println("Promedio de parciales: " + promedioParciales);
        System.out.println("Asistencia: " + porcentajeAsistencia + "%");
        System.out.println("Proyecto entregado: " + entregoProyecto);
        System.out.println("Calificación final: " + calificacionFinal);
        System.out.println("Estado: " + estadoFinal);
    }
}
