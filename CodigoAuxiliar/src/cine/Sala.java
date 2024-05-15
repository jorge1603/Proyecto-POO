package cine;
import java.util.Arrays;

public class Sala {
    private String pelicula;
    private String[] horasSesiones;
    private int filas;
    private int columnas;
    private Sesion[] sesiones;

    public Sala(String tituloPelicula, String[] horasSesiones, int filas, int columnas) {
        this.pelicula = tituloPelicula;
        this.horasSesiones = horasSesiones;
        this.filas = filas;
        this.columnas = columnas;
        this.sesiones = new Sesion[horasSesiones.length];
        for (int i = 0; i < horasSesiones.length; i++) {
            sesiones[i] = new Sesion(filas, columnas);
        }
    }
    public ButacasContiguas recomendarButacasContiguas1(int numButacas, int sesion) {
        if (sesion > 0 && sesion <= sesiones.length) {
            return sesiones[sesion - 1].recomendarButacasContiguas(numButacas);
        }
        return null;
    }
    public String getPelicula() {
        return pelicula;
    }

    public void comprarEntrada(int sesion, int fila, int columna) {
        sesiones[sesion - 1].comprarEntrada(fila, columna);
    }

    public int getIdEntrada(int sesion, int fila, int columna) {
        return sesiones[sesion - 1].getIdEntrada(fila, columna);
    }

    public String[] getHorasDeSesionesDeSala() {
        return horasSesiones;
    }

    public int[][] getEstadoSesion(int sesion) {
        return sesiones[sesion - 1].getEstado();
    }

    public int getButacasDisponiblesSesion(int sesion) {
        return sesiones[sesion - 1].getButacasDisponibles();
    }

    public String recogerEntradas(int idVenta, int sesion) {
        if (sesion > 0 && sesion <= sesiones.length) {
            return sesiones[sesion - 1].recogerEntradas(idVenta);
        }
        return null;
    }

    public ButacasContiguas recomendarButacasContiguas(int numButacas, int sesion) {
        if (sesion > 0 && sesion <= sesiones.length) {
            return sesiones[sesion - 1].recomendarButacasContiguas(numButacas);
        }
        return null;
    }

    public void comprarEntradasRecomendadas(ButacasContiguas butacas, int sesion) {
        if (sesion > 0 && sesion <= sesiones.length && butacas != null) {
            sesiones[sesion - 1].comprarEntradasRecomendadas(butacas);
        }
    }
}
