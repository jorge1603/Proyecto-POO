package cine;

public class Sala {
    private String pelicula; // Título de la película proyectada en la sala
    private Sesion[] sesiones; // Sesiones de la película en la sala
    private int filas; // Número de filas en la sala
    private int columnas; // Número de columnas en la sala

    public Sesion[] getSesiones() {
		return sesiones;
	}

	public void setSesiones(Sesion[] sesiones) {
		this.sesiones = sesiones;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	/**
     * Constructor de la clase Sala.
     * Inicializa el título de la película, las sesiones, el número de filas y columnas.
     * 
     * @param pelicula Título de la película
     * @param sesiones Vector de sesiones de la película
     * @param filas    Número de filas en la sala
     * @param columnas Número de columnas en la sala
     */
    public Sala(String pelicula, String[] sesiones, int filas, int columnas) {
        this.pelicula = pelicula;
        this.sesiones = new Sesion[sesiones.length];
        for (int i = 0; i < sesiones.length; i++) {
            this.sesiones[i] = new Sesion(sesiones[i], filas, columnas);
        }
        this.filas = filas;
        this.columnas = columnas;
    }

    /**
     * Obtiene el título de la película proyectada en la sala.
     * 
     * @return Título de la película
     */
    public String getPelicula() {
        return pelicula;
    }

    /**
     * Compra una entrada con la fila y columna dadas para la sesión dada.
     * La compra se registra en el objeto Sesion correspondiente.
     * 
     * @param sesion  Número de sesión (1 a N_SESIONES)
     * @param fila    Fila de la butaca (1 a número de filas de la sala)
     * @param columna Columna de la butaca (1 a número de asientos por fila)
     */
    public void comprarEntrada(int sesion, int fila, int columna) {
        sesiones[sesion - 1].comprarEntrada(fila, columna);
    }

    /**
     * Obtiene el identificador de venta para una entrada especificada por sesión, fila y columna.
     * 
     * @param sesion  Número de sesión (1 a N_SESIONES)
     * @param fila    Fila de la butaca (1 a número de filas de la sala)
     * @param columna Columna de la butaca (1 a número de asientos por fila)
     * @return Identificador de venta
     */
    public int getIdEntrada(int sesion, int fila, int columna) {
        return sesiones[sesion - 1].getIdEntrada(fila, columna);
    }

    /**
     * Obtiene un vector de String con las horas de las sesiones asociadas a la sala.
     * 
     * @return Vector de horas de sesiones
     */
    public String[] getHorasDeSesionesDeSala() {
        String[] horas = new String[sesiones.length];
        for (int i = 0; i < sesiones.length; i++) {
            horas[i] = sesiones[i].getHora();
        }
        return horas;
    }

    /**
     * Obtiene una matriz de caracteres que representa el estado de ocupación de la sala para una sesión.
     * 'X' indica que la butaca está ocupada, 'O' indica que está disponible.
     * 
     * @param sesion Número de sesión (1 a N_SESIONES)
     * @return Matriz de caracteres con el estado de ocupación
     */
    public char[][] getEstadoSesion(int sesion) {
        return sesiones[sesion - 1].getEstadoAsientos();
    }

    /**
     * Obtiene el número de butacas disponibles en la sala para una sesión.
     * 
     * @param sesion Número de sesión (1 a N_SESIONES)
     * @return Número de butacas disponibles
     */
    public int getButacasDisponiblesSesion(int sesion) {
        return sesiones[sesion - 1].getAsientosDisponibles();
    }

    /**
     * Recomienda butacas contiguas para una sesión.
     * 
     * @param numButacas Número de butacas contiguas solicitadas
     * @param sesion    Número de sesión (1 a N_SESIONES)
     * @return Objeto ButacasContiguas con la recomendación, o null si no hay suficientes butacas disponibles
     */
    public ButacasContiguas recomendarButacasContiguas(int numButacas, int sesion) {
        return sesiones[sesion - 1].recomendarButacasContiguas(numButacas);
    }

    /**
     * Compra las entradas recomendadas para una sesión.
     * 
     * @param sesion    Número de sesión (1 a N_SESIONES)
     * @param butacas  Objeto ButacasContiguas con las butacas a comprar
     */
    public void comprarEntradasRecomendadas(int sesion, ButacasContiguas butacas) {
        sesiones[sesion - 1].comprarEntradasRecomendadas(butacas);
    }

    /**
     * Recoge las entradas asociadas a un identificador de venta para una sesión.
     * 
     * @param id      Identificador de venta
     * @param sesion  Número de sesión (1 a N_SESIONES)
     * @return String con la información de las entradas, o null si el id no existe
     */
    public String recogerEntradas(int id, int sesion) {
        return sesiones[sesion - 1].recogerEntradas(id);
    }
}