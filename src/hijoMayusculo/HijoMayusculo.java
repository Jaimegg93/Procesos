package hijoMayusculo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class HijoMayusculo{

    public static void hijoMayusculo(Scanner t) {
        try {
            Process childProcess = new ProcessBuilder("C:\\Users\\jaime\\Desktop\\Calse\\Procesos\\Tema1\\HijoMayusculo\\bin\\Release\\HijoMayusculo.exe").start();

            PrintWriter childInput = new PrintWriter(childProcess.getOutputStream(), true);
            BufferedReader childOutput = new BufferedReader(new InputStreamReader(childProcess.getInputStream()));

            String line;
            System.out.println("Escribe una línea (o 'salir' para terminar):");

            while ((line = t.nextLine()) != null) {
                if (line.equalsIgnoreCase("salir")){
                    break;
                }
                childInput.println(line);

                String response = childOutput.readLine();
                System.out.println("Respuesta del hijo: " + response);
            }

            childProcess.destroy();
            childInput.close();
            childOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}