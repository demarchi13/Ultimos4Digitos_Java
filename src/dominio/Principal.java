package dominio;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		solucion();
	}
	
	public static void solucion() {
        // Inicializamos con los primeros tres números
        int a = 2023, b = 2024, c = 2025;

        // Inicializa el conjunto con los primeros tres números de la secuencia
        HashSet<Integer> ultimos4Digitos = new HashSet<>();
        ultimos4Digitos.add(a);
        ultimos4Digitos.add(b);
        ultimos4Digitos.add(c);

        // Lista para almacenar los resultados de los últimos cuatro dígitos
        List<Integer> secuencia = new LinkedList<>();
        secuencia.add(a % 10000);
        secuencia.add(b % 10000);
        secuencia.add(c % 10000);

        // Variable para detectar el ciclo y guardar la longitud del ciclo una vez encontrado
        int tamanioCiclo = -1;

        // El ciclo comienza con 4 porque ya tenemos los primeros 3 números
        for (int i = 4; i < 1000000; i++) {
            // Calcula d
            int d = (a + b + c) % 10000; // Solo los últimos cuatro dígitos

            // Imprime el valor de la posición 50
            if (i == 50) {
                System.out.printf("Los últimos cuatro dígitos en la posición 50 son %04d%n", d);
            }

            // Verifica si "d" ya está en el HashSet. Si es así, encontró un ciclo
            // y procede a calcular el tamaño de este
            if (ultimos4Digitos.contains(d)) {
                tamanioCiclo = i - 3; // Detectamos la longitud del ciclo
                break;
            }

            // Si "d" no está en el HashSet, lo agrega tanto en "ultimos4Digitos" y en "secuencia"
            // luego se actualiza el valor de a, b, c dejándolos listos para la siguiente vuelta
            ultimos4Digitos.add(d);
            secuencia.add(d);
            a = b;
            b = c;
            c = d;
        }

        // Verificación de ciclo
        if (tamanioCiclo == -1) {
            System.out.println("No se detectó un ciclo en el límite de iteraciones.");
            return;
        }

        // Cálculo e impresión de la longitud del ciclo
        System.out.println("Ciclo detectado de longitud " + tamanioCiclo);

        // Encontrar la posición dentro del ciclo calculando su módulo usando el tamaño del ciclo
        long position = 2023202320232023L % tamanioCiclo;

        // Obtener el resultado en la posición calculada
        int result = secuencia.get((int) position);

        System.out.printf("Los últimos cuatro dígitos en la posición 2023202320232023 son %04d%n", result);
    }

}
