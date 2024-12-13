package hilos.Interrupcion;

public class HiloInt2 implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido mientras dormia");
                break;
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Hilo interrumpido");
                break;
            }
            System.out.println(i);
            i++;

        }
    }
}
