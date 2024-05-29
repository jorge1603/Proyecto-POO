package interfazusuario;


public class ConsoleNotifier {

    public static void notify(int id, int fila, int columna, String hora, String pelicula) {
        System.out.println("ID de Entrada: " + id);
        System.out.println("Número de Fila: " + fila);
        System.out.println("Número de Columna: " + columna);
        System.out.println("Hora de Sesión: " + hora);
        System.out.println("Película: " + pelicula);
    }
}
