package hilos.hiloEjemplo1;

public class Ejercicio1Prueba extends Thread{
    int i;

    public  Ejercicio1Prueba(int i){
        this.i  = i;
    }

    public void run() {
        System.out.println("El hilo " + i + " funciona");
        System.out.println(currentThread().getName());
        System.out.println(currentThread().getId());
        System.out.println(currentThread().getPriority());
        System.out.println(currentThread().getState());

    }

    public static void main(String[] args) {

            Ejercicio1Prueba e = new Ejercicio1Prueba(1);
            e.start();

    }
}
