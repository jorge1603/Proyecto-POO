//Autores: Javier Belloch y Jorge Molina

package interfazusuario;
// Declaración del paquete interfazusuario

public class ConsoleNotifier {
    // Declaración de la clase ConsoleNotifier

    public static void notify(int id, int fila, int columna, String hora, String pelicula) {
        // Método notify() que notifica un evento de venta de entrada
        System.out.println("ID de Entrada: " + id);
        // Imprimir el ID de la entrada
        System.out.println("Número de Fila: " + fila);
        // Imprimir el número de fila
        System.out.println("Número de Columna: " + columna);
        // Imprimir el número de columna
        System.out.println("Hora de Sesión: " + hora);
        // Imprimir la hora de la sesión
        System.out.println("Película: " + pelicula);
        // Imprimir el título de la película
    }
}