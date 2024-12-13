package hilos.hiloEjemplo1;

public class HiloEjemplo1  extends Thread{

    private int c; //contador de cada hilo
    private int numero_hilo;

    //constructor
    public HiloEjemplo1 (int numero) {
        this.numero_hilo = numero;
        System.out.println("Creando hilo: " + numero_hilo);
    }

    public void run() {
        c = 0;
        if(numero_hilo == 2){
            System.out.println("Hilo interrumpido");
            this.interrupt();
        }else{
            while (c < 5) {
                System.out.println("Hilo numero: " + numero_hilo + " Contador(c) = " + c);
                c++;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <=3; i++) {
            HiloEjemplo1 h = new HiloEjemplo1(i); //crear hilo
            h.start();
            h.join();
        }
        System.out.println("3 hilos creados");
    }
}