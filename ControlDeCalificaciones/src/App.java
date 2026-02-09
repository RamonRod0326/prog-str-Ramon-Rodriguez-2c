public class App {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OutputPrinter outputPrinter = new OutputPrinter();
        GradeService gradeService = new GradeService();

        String nombreAlumno = inputReader.leerNombreAlumno();

        double parcialUno = inputReader.leerCalificacionParcial(1);
        double parcialDos = inputReader.leerCalificacionParcial(2);
        double parcialTres = inputReader.leerCalificacionParcial(3);

        int porcentajeAsistencia = inputReader.leerAsistencia();
        boolean entregoProyecto = inputReader.leerEntregaProyecto();

        double promedioParciales = gradeService.calcularPromedio(
                parcialUno, parcialDos, parcialTres
        );

        double calificacionFinal = gradeService.calcularFinal(
                promedioParciales, porcentajeAsistencia
        );

        String estadoFinal = gradeService.determinarEstado(
                calificacionFinal, porcentajeAsistencia, entregoProyecto
        );

        outputPrinter.imprimirReporte(
                nombreAlumno,
                parcialUno, parcialDos, parcialTres,
                promedioParciales,
                porcentajeAsistencia,
                entregoProyecto,
                calificacionFinal,
                estadoFinal
        );
    }
}
