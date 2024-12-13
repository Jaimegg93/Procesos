package procesos.wordle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Wordle {
    public static void wordle(){
        int intentos = 10;
        while(intentos>0){
            try{


            Process palabra = new ProcessBuilder("C:\\Users\\jaime\\Desktop\\Calse\\Procesos\\Tema1\\Verdadero\\bin\\Release\\Verdadero.exe").start();
            Process analizador = new ProcessBuilder("C:\\Users\\jaime\\Desktop\\Calse\\Procesos\\Tema1\\Mentiroso\\bin\\Release\\Mentiroso.exe").start();

            BufferedReader lectorpalabra = new BufferedReader(new InputStreamReader(palabra.getInputStream()));
            BufferedReader lectoranalizador = new BufferedReader(new InputStreamReader(analizador.getInputStream()));

            PrintWriter escritorpalabra = new PrintWriter(palabra.getOutputStream(), true);
            PrintWriter escritoranalizador = new PrintWriter(analizador.getOutputStream(), true);



            intentos--;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
