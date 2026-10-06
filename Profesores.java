import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Profesor {
    String nombre;
    int edad;
    String categoria;

    Profesor(String nombre, int edad, String categoria) {
        this.nombre = nombre;
        this.edad = edad;
        this.categoria = categoria;
    }
}

class ListaProfesores {
    private Node head;

    private class Node {
        Profesor profesor;
        Node next;

        Node(Profesor profesor) {
            this.profesor = profesor;
            this.next = null;
        }
    }

    // Método para agregar un profesor a la lista
    public void addProfesor(Profesor profesor) {
        Node newNode = new Node(profesor);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Método ProxCambio: Devuelve nombres de profesores próximos a cambiar de categoría
    public List<String> ProxCambio() {
        List<String> proxCambio = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.profesor.categoria.equals("Asistente") && current.profesor.edad > 26) {
                proxCambio.add(current.profesor.nombre);
            }
            current = current.next;
        }
        return proxCambio;
    }

    // Método MostrarLista: Muestra la lista de profesores ordenados por edad de mayor a menor
    public void MostrarLista() {
        Node current = head;
        while (current != null) {
            System.out.println("Nombre: " + current.profesor.nombre + ", Edad: " + current.profesor.edad + ", Categoría: " + current.profesor.categoria);
            current = current.next;
        }
    }

    // Método CantProfesores: Devuelve la cantidad de profesores por categoría docente
    public String CantProfesores() {
        Map<String, Integer> cantProfesores = new HashMap<>();
        Node current = head;
        while (current != null) {
            cantProfesores.put(current.profesor.categoria, cantProfesores.getOrDefault(current.profesor.categoria, 0) + 1);
            current = current.next;
        }
        StringBuilder result = new StringBuilder();
        cantProfesores.forEach((categoria, cantidad) -> {
            result.append(categoria + ": " + cantidad + "\n");
        });
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        ListaProfesores lista = new ListaProfesores();

        lista.addProfesor(new Profesor("Juan", 30, "Instructor"));
        lista.addProfesor(new Profesor("Ana", 28, "Asistente"));
        lista.addProfesor(new Profesor("Pedro", 35, "Asistente"));
        lista.addProfesor(new Profesor("María", 32, "Auxiliar"));
        lista.addProfesor(new Profesor("Carlos", 25, "Titular"));

        System.out.println("Profesores próximos a cambiar de categoría:");
        for (String nombre : lista.ProxCambio()) {
            System.out.println(nombre);
        }

        System.out.println("\nLista de profesores ordenada por edad:");
        lista.MostrarLista();

        System.out.println("\nCantidad de profesores por categoría:");
        System.out.println(lista.CantProfesores());
    }
}
