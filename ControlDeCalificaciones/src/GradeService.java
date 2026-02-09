public class GradeService {

    public double calcularPromedio(
            double parcialUno,
            double parcialDos,
            double parcialTres
    ) {
        return (parcialUno + parcialDos + parcialTres) / 3;
    }

    public double calcularFinal(
            double promedioParciales,
            int porcentajeAsistencia
    ) {
        return (promedioParciales * 0.7) + (porcentajeAsistencia * 0.3);
    }

    public String determinarEstado(
            double calificacionFinal,
            int porcentajeAsistencia,
            boolean entregoProyecto
    ) {
        if (porcentajeAsistencia < 80) {
            return "REPROBADO por asistencia";
        }

        if (!entregoProyecto) {
            return "REPROBADO por proyecto";
        }

        if (calificacionFinal >= 70) {
            return "APROBADO";
        }

        return "REPROBADO por calificación";
    }
}
