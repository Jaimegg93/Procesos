package procesos.wordle;

import java.io.*;
import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {
        try {
            wordle();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void wordle() throws IOException {
        Scanner sc = new Scanner(System.in);
        int vuelta = 0;
        String intento = " ";
        String palabra = "";

        while (true) {
            if (vuelta == 10) {
                System.out.println("Mas suerte la proxima");
                break;
            }
            Process procesoPadre = new ProcessBuilder("D:\\Clase\\Programacion de Procesos\\Proyectos\\untitled1\\cmake-build-debug\\untitled1.exe").start();

            // Crear el escritor para enviar datos al programa C
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(procesoPadre.getOutputStream()));

            // Solicitar al usuario que introduzca una palabra

            System.out.println("Escribe tu intento (ESCRIBE EN MAYUSCULAS)");
            intento = sc.nextLine();

            // Enviar la palabra al programa C
            writer.write(intento);
            writer.newLine(); // Enviar un salto de línea para que el programa C reciba la entrada
            writer.close();

            // Leer la salida del programa C
            BufferedReader reader = new BufferedReader(new InputStreamReader(procesoPadre.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("Salida del preso Hijo: " + linea);
                palabra = linea;
            }
            if (intento.equals(palabra)) {
                System.out.println("Felicidades!!");
                break;
            }
            reader.close();
            vuelta++;
        }
    }
}