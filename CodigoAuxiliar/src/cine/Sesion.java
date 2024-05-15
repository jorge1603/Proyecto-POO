package cine;

public class Sesion {
    private String hora;
    private int[][] estadoAsientos;
    private int asientosDisponibles;
    private int sigIdCompra;

    public Sesion(int filas, int columnas) {
        this.estadoAsientos = new int[filas][columnas];
        this.asientosDisponibles = filas * columnas;
        this.sigIdCompra = 1;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int[][] getEstado() {
        return estadoAsientos;
    }

    public int getButacasDisponibles() {
        return asientosDisponibles;
    }

    public void comprarEntrada(int fila, int columna) {
        if (estadoAsientos[fila - 1][columna - 1] == 0) {
            estadoAsientos[fila - 1][columna - 1] = sigIdCompra;
            sigIdCompra++;
            asientosDisponibles--;
        }
    }

    public int getIdEntrada(int fila, int columna) {
        return estadoAsientos[fila - 1][columna - 1];
    }

    public String recogerEntradas(int idVenta) {
        StringBuilder entradas = new StringBuilder();
        boolean encontrada = false;
        for (int i = 0; i < estadoAsientos.length; i++) {
            for (int j = 0; j < estadoAsientos[i].length; j++) {
                if (estadoAsientos[i][j] == idVenta) {
                    encontrada = true;
                    entradas.append("--").append(i + 1).append(",").append(j + 1);
                    estadoAsientos[i][j] = 0;
                    asientosDisponibles++;
                }
            }
        }
        return encontrada ? entradas.toString().substring(2) : null;
    }

    public ButacasContiguas recomendarButacasContiguas(int numButacas) {
        // Implementación de la recomendación de butacas contiguas
        // Aquí debes implementar la lógica para recomendar las butacas contiguas
        // Puedes usar cualquier algoritmo que prefieras para este propósito
        // Retornarías un objeto de tipo ButacasContiguas con la fila y columna recomendadas
        return null;
    }

    public void comprarEntradasRecomendadas(ButacasContiguas butacas) {
        // Implementación para comprar las butacas recomendadas
        // Aquí deberías marcar las butacas como compradas en el estadoAsientos
        // y actualizar el número de asientos disponibles
    }
}