package hilos.scrum;

import java.io.*;
import java.util.ArrayList;

public class Scrum extends Thread {
    private ArrayList<Tarea> tareon;

    public Scrum(ArrayList<Tarea> tareon) {
        this.tareon = tareon;
    }

    public ArrayList<Tarea> getTareon() {
        return tareon;
    }

    @Override
    public void run() {
        if (!tareon.isEmpty()) {
            Tarea currentTarea = tareon.get(0);

            try {
                // Ejecutar el proceso externo
                Process process = Runtime.getRuntime().exec("C:\\Users\\jaime\\Desktop\\Calse\\Procesos\\Tema1\\Scrout\\bin\\Release\\Scrout.exe");

                // Flujo de entrada y salida para comunicarse con el proceso
                BufferedReader lector = new BufferedReader(new InputStreamReader(process.getInputStream()));
                PrintWriter escritor = new PrintWriter(process.getOutputStream(), true);

                // Enviar el número de la tarea al proceso
                escritor.println(currentTarea.getNumero());
                escritor.flush();

                // Leer la respuesta del proceso
                String respuesta = lector.readLine();

                // Manejar la respuesta
                if ("1".equals(respuesta)) {
                    System.out.println("Tarea borrada: " + currentTarea.getTexto() + " Difcultad " + currentTarea.getNumero());
                    synchronized (tareon) {
                        tareon.remove(0);
                    }
                } else {
                    System.out.println("Error: " + respuesta);
                }

                // Cerrar recursos
                lector.close();
                escritor.close();
                process.destroy();

            } catch (IOException e) {
                System.err.println("Error durante la ejecución: " + e.getMessage());
            }
        }
    }
}
