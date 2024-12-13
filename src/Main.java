import hilos.scrum.Scrum;
import hilos.scrum.Tarea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        ArrayList<Tarea> tareon = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jaime\\Desktop\\Calse\\Procesos\\Procesos\\src\\hilos\\scrum\\lista.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                Tarea ts = new Tarea(partes[0], partes[1]);
                tareon.add(ts);
            }

            while (!tareon.isEmpty()) {
                Scrum hilo = new Scrum(tareon);
                hilo.start();
                hilo.join();
                tareon = hilo.getTareon();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lista borrada");
    }
}
