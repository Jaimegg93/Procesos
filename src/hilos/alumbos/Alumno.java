package hilos.alumbos;

public class Alumno implements Runnable {

    String mensaje;
    String nombre;

    public Alumno(String nombre) {
        this.mensaje = "Hola soy " + nombre + " y este es mi mensaje numero";
        this.nombre = nombre;
    }

    @Override
    public void run() {
        if (nombre.equals("Jaime")) {
            System.out.println("Tu puta madre soy Jaime");
            Thread.currentThread().interrupt();
        } else {
            for (int i = 1; i <= 5; i++) {
                System.out.println(mensaje + " " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Alumno a1 = new Alumno("Jaime");
        Alumno a2 = new Alumno("Pedro");
        Alumno a3 = new Alumno("Miguel");

        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);
        Thread t3 = new Thread(a3);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}
