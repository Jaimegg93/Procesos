package hilos.hiloEjemplo1;

import java.util.Scanner;

public class Ejercicio2Runneable implements Runnable{
    String texto;

    public Ejercicio2Runneable(String t){
        this.texto = t;
    }

    @Override
    public void run() {
        synchronized (System.out) {//Solo pueden escribir en la consola 1 a la vez
            for (int i = 0; i < 10; i++) {
                System.out.println(texto);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.println("Escribe un texto");
        String texto = t.nextLine();
        System.out.println("Tienes estas opciones");
        System.out.println("1 Crear hilo (extends Thread)");
        System.out.println("2  Crear hilo (implements Runnable)");
        System.out.println("3 Crear 4 hilos (2 de cada tipo)");
        System.out.println("4  Salir");
        String num = t.next();

        if(num.equals("1")){
            Ejercicio2Thread pp = new Ejercicio2Thread(texto);
            pp.start();
        } else if (num.equals("2")) {
            Ejercicio2Runneable eee = new Ejercicio2Runneable(texto);
            eee.run();
        } else if (num.equals("3")) {
            Ejercicio2Thread p1 = new Ejercicio2Thread(texto);
            p1.start();

            Ejercicio2Thread p2 = new Ejercicio2Thread(texto);
            p2.start();

            Ejercicio2Runneable e1 = new Ejercicio2Runneable(texto);
            Ejercicio2Runneable e2 = new Ejercicio2Runneable(texto);
            Thread t1 = new Thread(e1);
            Thread t2 = new Thread(e2);
            t1.start();
            t2.start();
        }
    }
}
