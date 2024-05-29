//Autores: Javier Belloch y Jorge Molina

package cine;

public class Sesion {
    private String hora; // Hora de la sesión en formato HH:MM
    private int[][] estadoAsientos; // Matriz de enteros que representa el estado de ocupación de los asientos
    private int asientosDisponibles; // Número de asientos disponibles
    private int sigIdCompra; // Identificador de venta siguiente

    public int getSigIdCompra() {
		return sigIdCompra;
	}

	public void setSigIdCompra(int sigIdCompra) {
		this.sigIdCompra = sigIdCompra;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setEstadoAsientos(int[][] estadoAsientos) {
		this.estadoAsientos = estadoAsientos;
	}

	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	/**
     * Constructor de la clase Sesion.
     * Inicializa la hora de la sesión, la matriz de estado de los asientos, los asientos disponibles y el siguiente identificador de venta.
     * 
     * @param hora    Hora de la sesión en formato HH:MM
     * @param filas   Número de filas de la sala asociada a la sesión
     * @param columnas Número de columnas de la sala asociada a la sesión
     */
    public Sesion(String hora, int filas, int columnas) {
        this.hora = hora;
        this.estadoAsientos = new int[filas][columnas];
        this.asientosDisponibles = filas * columnas;
        this.sigIdCompra = 1;
    }

    /**
     * Obtiene la hora de la sesión.
     * 
     * @return Hora de la sesión en formato HH:MM
     */
    public String getHora() {
        return hora;
    }

    /**
     * Compra una entrada con la fila y columna dadas para la sesión.
     * La compra queda registrada en la matriz de estado de los asientos.
     * 
     * @param fila    Fila de la butaca (1 a número de filas de la sala)
     * @param columna Columna de la butaca (1 a número de asientos por fila de la sala)
     */
    public void comprarEntrada(int fila, int columna) {
        estadoAsientos[fila - 1][columna - 1] = sigIdCompra;
        sigIdCompra++;
        asientosDisponibles--;
    }

    /**
     * Obtiene el identificador de venta para una entrada especificada por fila y columna.
     * 
     * @param fila    Fila de la butaca (1 a número de filas de la sala)
     * @param columna Columna de la butaca (1 a número de asientos por fila de la sala)
     * @return Identificador de venta asociado a la butaca
     */
    public int getIdEntrada(int fila, int columna) {
        return estadoAsientos[fila - 1][columna - 1];
    }

    /**
     * Obtiene la matriz de caracteres que representa el estado de ocupación de la sala para la sesión.
     * 'X' indica que la butaca está ocupada, 'O' indica que está disponible.
     * 
     * @return Matriz de caracteres con el estado de ocupación de los asientos
     */
    public char[][] getEstadoAsientos() {
        char[][] estado = new char[estadoAsientos.length][estadoAsientos[0].length];
        for (int i = 0; i < estadoAsientos.length; i++) {
            for (int j = 0; j < estadoAsientos[0].length; j++) {
                estado[i][j] = (estadoAsientos[i][j] == 0) ? 'O' : 'X';
            }
        }
        return estado;
    }

    /**
     * Obtiene el número de butacas disponibles en la sesión.
     * 
     * @return Número de butacas disponibles
     */
    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    /**
     * Recoge las N entradas asociadas a un identificador de venta dado para la sesión.
     * 
     * @param id Identificador de venta
     * @return String con la información de las entradas, o null si el id no existe
     */
    public String recogerEntradas(int id) {
        StringBuilder entradas = new StringBuilder();
        for (int i = 0; i < estadoAsientos.length; i++) {
            for (int j = 0; j < estadoAsientos[0].length; j++) {
                if (estadoAsientos[i][j] == id) {
                    entradas.append("--").append(i + 1).append(",").append(j + 1);
                }
            }
        }
        return (entradas.length() > 0) ? entradas.substring(2) : null;
    }

    /**
     * Recomienda butacas contiguas para la sesión.
     * 
     * @param numButacas Número de butacas contiguas solicitadas
     * @return Objeto ButacasContiguas con la recomendación, o null si no hay suficientes butacas disponibles
     */
    public ButacasContiguas recomendarButacasContiguas(int numButacas) {
        // Algoritmo para recomendar butacas contiguas
        // Se busca y se devuelve un objeto ButacasContiguas con la recomendación
        return null; // Devolver null si no hay suficientes butacas disponibles
    }
    
    /**
     * Compra las entradas recomendadas para la sesión actual.
     * 
     * @param butacas Objeto ButacasContiguas que contiene las butacas a comprar
     */
    public void comprarEntradasRecomendadas(ButacasContiguas butacas) {
        int fila = butacas.getFila();
        int columna = butacas.getColumna();
        int numButacas = butacas.getNoButacas();
        
        // Comprar las entradas recomendadas
        for (int i = 0; i < numButacas; i++) {
            estadoAsientos[fila - 1][columna + i - 1] = sigIdCompra;
            asientosDisponibles--;
        }
        sigIdCompra++;
    }

}