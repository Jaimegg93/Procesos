package hilos.Interrupcion;

public class InterruptEjemplo {
    public static void main(String[] args) {

        HiloInt2 tarea = new HiloInt2();
        Thread t = new Thread(tarea);
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        t.interrupt();
    }
}
