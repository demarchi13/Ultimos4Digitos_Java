package dominio;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		solucion();
	}
	
	public static void solucion() {
        // Inicializamos con los primeros tres n�meros
        int a = 2023, b = 2024, c = 2025;

        // Inicializa el conjunto con los primeros tres n�meros de la secuencia
        HashSet<Integer> ultimos4Digitos = new HashSet<>();
        ultimos4Digitos.add(a);
        ultimos4Digitos.add(b);
        ultimos4Digitos.add(c);

        // Lista para almacenar los resultados de los �ltimos cuatro d�gitos
        List<Integer> secuencia = new LinkedList<>();
        secuencia.add(a % 10000);
        secuencia.add(b % 10000);
        secuencia.add(c % 10000);

        // Variable para detectar el ciclo y guardar la longitud del ciclo una vez encontrado
        int tamanioCiclo = -1;

        // El ciclo comienza con 4 porque ya tenemos los primeros 3 n�meros
        for (int i = 4; i < 1000000; i++) {
            // Calcula d
            int d = (a + b + c) % 10000; // Solo los �ltimos cuatro d�gitos

            // Imprime el valor de la posici�n 50
            if (i == 50) {
                System.out.printf("Los �ltimos cuatro d�gitos en la posici�n 50 son %04d%n", d);
            }

            // Verifica si "d" ya est� en el HashSet. Si es as�, encontr� un ciclo
            // y procede a calcular el tama�o de este
            if (ultimos4Digitos.contains(d)) {
                tamanioCiclo = i - 3; // Detectamos la longitud del ciclo
                break;
            }

            // Si "d" no est� en el HashSet, lo agrega tanto en "ultimos4Digitos" y en "secuencia"
            // luego se actualiza el valor de a, b, c dej�ndolos listos para la siguiente vuelta
            ultimos4Digitos.add(d);
            secuencia.add(d);
            a = b;
            b = c;
            c = d;
        }

        // Verificaci�n de ciclo
        if (tamanioCiclo == -1) {
            System.out.println("No se detect� un ciclo en el l�mite de iteraciones.");
            return;
        }

        // C�lculo e impresi�n de la longitud del ciclo
        System.out.println("Ciclo detectado de longitud " + tamanioCiclo);

        // Encontrar la posici�n dentro del ciclo calculando su m�dulo usando el tama�o del ciclo
        long position = 2023202320232023L % tamanioCiclo;

        // Obtener el resultado en la posici�n calculada
        int result = secuencia.get((int) position);

        System.out.printf("Los �ltimos cuatro d�gitos en la posici�n 2023202320232023 son %04d%n", result);
    }

}
