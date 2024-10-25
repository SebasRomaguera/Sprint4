package sprint4;

import java.util.Scanner;

public class PuntosEstudiante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;

        // Validar el número de registro
        while (true) {
            System.out.println("¿Cuál es su número de registro? (1-499):");
            numero = sc.nextInt(); // Leer la entrada como int
            
            if (numero >= 1 && numero <= 499) {
                break; // Salir del bucle si el número es válido
            } else {
                System.out.println("El número no es correcto, introduzca otro (debe estar entre 1 y 499).");
            }
        }

        // Preguntas para acumular puntos
        int hermanoCentro = obtenerRespuesta(sc, "¿Tiene algún herman@ en el centro (0: no / 1: sí)?:");
        int mismaPoblacion = obtenerRespuesta(sc, "¿Vive en la misma población (0: no / 1: sí)?:");
        int trabajaMismaPoblacion = obtenerRespuesta(sc, "¿Alguno de sus padres trabaja en la misma población (0: no / 1: sí)?:");
        int Discapacidad = obtenerRespuesta(sc, "¿Tiene alguna discapacidad igual o superior al 33% o enfermedad crónica (0: no / 1: sí)?:");
        int familiaNumerosaOMonoparental = obtenerRespuesta(sc, "¿Forma parte de una familia numerosa o monoparental (0: no / 1: sí)?:");
        int escolarizado = obtenerRespuesta(sc, "¿Padre, madre, tutor legal o hermano ha estado escolarizado en la misma escuela (0: no / 1: sí)?:");

        // Calcular puntos
        int puntos = 0;

        if (hermanoCentro == 1) {
            puntos += 40;
        }

        if (mismaPoblacion == 1) {
            puntos += 30;
        } else if (trabajaMismaPoblacion == 1) {
            puntos += 20;
        }

        if (Discapacidad == 1) {
            puntos += 10;
        }

        if (familiaNumerosaOMonoparental == 1) {
            puntos += 15;
        }

        if (escolarizado == 1) {
            puntos += 5;
        }

        // Resultados finales
        System.out.println("Su número de registro es " + numero);
        System.out.println("La puntuación obtenida es de: " + puntos);
    }

    // Método para obtener respuestas válidas
    private static int obtenerRespuesta(Scanner sc, String mensaje) {
        int respuesta = -1; // Inicializa en un valor no válido
        while (true) {
            System.out.println(mensaje);
            respuesta = sc.nextInt(); // Leer la entrada como int

            if (respuesta == 0 || respuesta == 1) {
                return respuesta; // Retorna si la respuesta es válida
            } else {
                System.out.println("Respuesta no válida. Debe introducir 0 o 1.");
            }
        }
    }
}
