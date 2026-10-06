import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Estudiante {
    String ci;
    String nombre;
    String apellido;
    String sexo;
    int año;
    boolean esMilitanteUJC;
    boolean esBecado;

    Estudiante(String ci, String nombre, String apellido, String sexo, int año, boolean esMilitanteUJC, boolean esBecado) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.año = año;
        this.esMilitanteUJC = esMilitanteUJC;
        this.esBecado = esBecado;
    }

    @Override
    public String toString() {
        return "CI: " + ci + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Sexo: " + sexo + ", Año: " + año;
    }
}

class ListaEstudiantes {
    private Node head;

    private class Node {
        Estudiante estudiante;
        Node next;

        Node(Estudiante estudiante) {
            this.estudiante = estudiante;
            this.next = null;
        }
    }

    // Método para agregar un estudiante a la lista
    public void addEstudiante(Estudiante estudiante) {
        Node newNode = new Node(estudiante);
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

    // Método Cumpleaños: Devuelve nombres de estudiantes que cumplen años en un determinado mes
    public List<String> Cumpleaños(String mes) {
        List<String> cumplenAños = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (mes.equalsIgnoreCase(current.estudiante.año)) {
                cumplenAños.add(current.estudiante.nombre);
            }
            current = current.next;
        }
        return cumplenAños;
    }

    // Método CantMilitantes: Devuelve estudiantes militantes de la UJC ordenados por año de menor a mayor
    public List<Estudiante> CantMilitantes() {
        List<Estudiante> militantes = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.estudiante.esMilitanteUJC) {
                militantes.add(current.estudiante);
            }
            current = current.next;
        }
        militantes.sort(Comparator.comparingInt(Estudiante::getAño));
        return militantes;
    }

    // Método CantBecados: Devuelve la cantidad de estudiantes becados
    public int CantBecados() {
        int cantBecados = 0;
        Node current = head;
        while (current != null) {
            if (current.estudiante.esBecado) {
                cantBecados++;
            }
            current = current.next;
        }
        return cantBecados;
    }
}

public class Main {
    public static void main(String[] args) {
        ListaEstudiantes lista = new ListaEstudiantes();

        lista.addEstudiante(new Estudiante("123456789", "Juan", "Pérez", "Masculino", 2000, true, true));
        lista.addEstudiante(new Estudiante("987654321", "Ana", "García", "Femenino", 2001, false, false));
        lista.addEstudiante(new Estudiante("456789123", "Pedro", "López", "Masculino", 2000, true, false));
        lista.addEstudiante(new Estudiante("321654987", "María", "Martínez", "Femenino", 2001, true, true));
        lista.addEstudiante(new Estudiante("789123456", "Carlos", "Rodríguez", "Masculino", 2000, false, true));

        System.out.println("Estudiantes que cumplen años en enero:");
        for (String nombre : lista.Cumpleaños("enero")) {
            System.out.println(nombre);
        }

        System.out.println("\nEstudiantes militantes de la UJC ordenados por año:");
        for (Estudiante estudiante : lista.CantMilitantes()) {
            System.out.println(estudiante);
        }

        System.out.println("\nCantidad de estudiantes becados:");
        System.out.println(lista.CantBecados());
    }
}
