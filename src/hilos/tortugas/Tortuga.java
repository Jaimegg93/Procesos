package hilos.tortugas;

import java.util.Random;

public class Tortuga implements Runnable {
    int dorsal;
    int velocidad;
    int metros = 0;

    public Tortuga(int dorsal) {
        this.dorsal = dorsal;
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        Random random = new Random();
        this.velocidad = random.nextInt(11);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("La tortuga(" + this.dorsal + ") ha avanzado " + velocidad);
        metros += velocidad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public static void main(String[] args) throws InterruptedException {
        Tortuga t1 = new Tortuga(1);

        Tortuga t2 = new Tortuga(2);

        Tortuga t3 = new Tortuga(3);

        int cont = 1;

        while (true) {
            Thread tt1 = new Thread(t1);
            Thread tt2 = new Thread(t2);
            Thread tt3 = new Thread(t3);
            tt1.start();
            tt1.join();
            tt2.start();
            tt2.join();
            tt3.start();
            tt3.join();
            System.out.println("Punto de control: " + cont);
            cont++;
            if (t1.getMetros() >= 100 && t2.getMetros() >= 100) {
                System.out.println("Empate");
                break;
            } else if (t1.getMetros() >= 100) {
                System.out.println("Ha ganado la tortuga " + t1.getDorsal());
                break;
            } else if (t2.getMetros() >= 100) {
                System.out.println("Ha ganado la tortuga " + t2.getDorsal());
                break;
            } else if (t3.getMetros() >= 100) {
                System.out.println("Ha ganado la tortuga " + t2.getDorsal());
                break;
            }
        }
    }
}
