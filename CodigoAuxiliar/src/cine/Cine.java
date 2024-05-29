//Autores: Javier Belloch y Jorge Molina

package cine;

public class Cine {
    private String nombre; // Nombre del cine
    private Sala[] salas; // Salas del cine representadas por un vector de objetos Sala

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sala[] getSalas() {
		return salas;
	}

	public void setSalas(Sala[] salas) {
		this.salas = salas;
	}

	/**
     * Constructor de la clase Cine.
     * Inicializa el nombre del cine y las salas.
     * 
     * @param nombre Nombre del cine
     * @param salas   Vector de salas del cine
     */
    public Cine(String nombre, Sala[] salas) {
        this.nombre = nombre;
        this.salas = salas;
    }

    /**
     * Compra una entrada con la fila y columna dadas para la sala y sesión especificadas.
     * La compra se registra en el objeto Sesion correspondiente.
     * 
     * @param sala    Número de sala (1 a N_SALAS)
     * @param sesion  Número de sesión (1 a N_SESIONES)
     * @param fila    Fila de la butaca (1 a número de filas de la sala)
     * @param columna Columna de la butaca (1 a número de asientos por fila)
     */
    public void comprarEntrada(int sala, int sesion, int fila, int columna) {
        salas[sala - 1].comprarEntrada(sesion, fila, columna);
    }

    /**
     * Obtiene el identificador de venta para una entrada especificada por sala, sesión, fila y columna.
     * 
     * @param sala    Número de sala (1 a N_SALAS)
     * @param sesion  Número de sesión (1 a N_SESIONES)
     * @param fila    Fila de la butaca (1 a número de filas de la sala)
     * @param columna Columna de la butaca (1 a número de asientos por fila)
     * @return Identificador de venta
     */
    public int getIdEntrada(int sala, int sesion, int fila, int columna) {
        return salas[sala - 1].getIdEntrada(sesion, fila, columna);
    }

    /**
     * Obtiene un vector de String con los títulos de las películas proyectadas en el cine.
     * 
     * @return Vector de títulos de películas
     */
    public String[] getPeliculas() {
        String[] peliculas = new String[salas.length];
        for (int i = 0; i < salas.length; i++) {
            peliculas[i] = salas[i].getPelicula();
        }
        return peliculas;
    }

    /**
     * Obtiene un vector de String con las horas de las sesiones de una sala.
     * 
     * @param sala Número de sala (1 a N_SALAS)
     * @return Vector de horas de sesiones
     */
    public String[] getHorasDeSesionesDeSala(int sala) {
        return salas[sala - 1].getHorasDeSesionesDeSala();
    }

    /**
     * Obtiene una matriz de caracteres que representa el estado de ocupación de una sala para una sesión.
     * 'X' indica que la butaca está ocupada, 'O' indica que está disponible.
     * 
     * @param sala   Número de sala (1 a N_SALAS)
     * @param sesion Número de sesión (1 a N_SESIONES)
     * @return Matriz de caracteres con el estado de ocupación
     */
    public char[][] getEstadoSesion(int sala, int sesion) {
        return salas[sala - 1].getEstadoSesion(sesion);
    }

    /**
     * Obtiene el número de butacas disponibles en una sala para una sesión.
     * 
     * @param sala   Número de sala (1 a N_SALAS)
     * @param sesion Número de sesión (1 a N_SESIONES)
     * @return Número de butacas disponibles
     */
    public int getButacasDisponiblesSesion(int sala, int sesion) {
        return salas[sala - 1].getButacasDisponiblesSesion(sesion);
    }

    /**
     * Obtiene las entradas asociadas a un identificador de venta para una sala y sesión.
     * 
     * @param id     Identificador de venta
     * @param sala   Número de sala (1 a N_SALAS)
     * @param sesion Número de sesión (1 a N_SESIONES)
     * @return String con la información de las entradas, o null si el id no existe
     */
    public String recogerEntradas(int id, int sala, int sesion) {
        return salas[sala - 1].recogerEntradas(id, sesion);
    }

    /**
     * Recomienda butacas contiguas para una sala y sesión.
     * 
     * @param numButacas Número de butacas contiguas solicitadas
     * @param sala       Número de sala (1 a N_SALAS)
     * @param sesion     Número de sesión (1 a N_SESIONES)
     * @return Objeto ButacasContiguas con la recomendación, o null si no hay suficientes butacas disponibles
     */
    public ButacasContiguas recomendarButacasContiguas(int numButacas, int sala, int sesion) {
        return salas[sala - 1].recomendarButacasContiguas(numButacas, sesion);
    }

    /**
     * Compra las entradas recomendadas para una sala y sesión.
     * 
     * @param sala    Número de sala (1 a N_SALAS)
     * @param sesion  Número de sesión (1 a N_SESIONES)
     * @param butacas Objeto ButacasContiguas con las butacas a comprar
     */
    public void comprarEntradasRecomendadas(int sala, int sesion, ButacasContiguas butacas) {
        salas[sala - 1].comprarEntradasRecomendadas(sesion, butacas);
    }

    /**
     * Obtiene el nombre del cine.
     * 
     * @return Nombre del cine
     */
    public String getNombreCine() {
        return nombre;
    }
}