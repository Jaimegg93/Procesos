package mentirosos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mentiroso {

    public static void mentiroso(Scanner t) {
        try {
            while (true) {
                Process verdadero = new ProcessBuilder("C:\\Users\\jaime\\Desktop\\Calse\\Procesos\\Tema1\\Verdadero\\bin\\Release\\Verdadero.exe").start();
                Process mentiros = new ProcessBuilder("C:\\Users\\jaime\\Desktop\\Calse\\Procesos\\Tema1\\Mentiroso\\bin\\Release\\Mentiroso.exe").start();

                BufferedReader lectorVerdadero = new BufferedReader(new InputStreamReader(verdadero.getInputStream()));
                BufferedReader lectormentiros = new BufferedReader(new InputStreamReader(mentiros.getInputStream()));

                PrintWriter escritorVerdadero = new PrintWriter(verdadero.getOutputStream(), true);
                PrintWriter escritorMentiros = new PrintWriter(mentiros.getOutputStream(), true);

                System.out.println("A que proceso quieres preguntarle? 1 o 2 (para salir 3)");
                int pregunta = t.nextInt();

                if (pregunta == 3) {
                    break;
                } else if (pregunta == 1) {
                    System.out.println("Escribe un numero");
                    String numero = t.next();
                    escritorVerdadero.println(numero);

                    String r = lectorVerdadero.readLine();
                    System.out.println("La respuesta es: "+r);
                } else if (pregunta == 2) {
                    System.out.println("Escribe un numero");
                    String numero = t.next();
                    escritorMentiros.println(numero);

                    String r = lectormentiros.readLine();
                    System.out.println("La respuesta es: "+r);
                }
                lectormentiros.close();
                lectorVerdadero.close();

                escritorVerdadero.close();
                escritorMentiros.close();

                verdadero.destroy();
                mentiros.destroy();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
