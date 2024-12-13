package hilos.scrum;

public class Tarea {
    String texto;
    String  numero;

    public Tarea(String textoo, String numeroo){
        this.texto = textoo;
        this.numero = numeroo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "texto='" + texto + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
