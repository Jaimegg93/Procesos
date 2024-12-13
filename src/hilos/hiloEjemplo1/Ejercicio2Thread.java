package hilos.hiloEjemplo1;

public class Ejercicio2Thread extends Thread{
    String texto;

    public Ejercicio2Thread(String t){
        this.texto = t;
    }

    @Override
    public void run() {
        synchronized (System.out) {
            for (int i = 0; i < 10; i++) {
                System.out.println(texto);
            }
            System.out.println("\n");
        }
    }
}
