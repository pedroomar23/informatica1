# Ejercicios de Estructuras de Datos 1

Este repositorio contiene tres ejercicios relacionados con estructuras de datos, implementadas en Java

1. **Ejercicio 1**: Control de profesores usando una lista simplemente enlazada.
2. **Ejercicio 2**: Control de estudiantes usando una lista simplemente enlazada.
3. **Ejercicio 3**: Control de departamentos usando una lista simplemente enlazada.

## Descripción

Los ejercicios se enfocan en la implementación de estructuras de datos en Java y los métodos que se deben implementar para cumplir con los requisitos del sistema. Cada ejercicio se desarrolla con el objetivo de practicar y comprender mejor las operaciones básicas de una lista enlazada.

## Solución de los Ejercicios

### Ejercicio 1: Control de Profesores

#### Implementación

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Profesor {
    String nombre;
    int edad;
    String categoriaDocente;

    Profesor(String nombre, int edad, String categoriaDocente) {
        this.nombre = nombre;
        this.edad = edad;
        this.categoriaDocente = categoriaDocente;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Categoría Docente: " + categoriaDocente;
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
        List<String> proximosA Cambio = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.profesor.edad > 26 && !current.profesor.categoriaDocente.equals("Titular")) {
                proximosACambio.add(current.profesor.nombre);
            }
            current = current.next;
        }
        return proximosACambio;
    }

    // Método CantProfesores: Devuelve cantidad de profesores por categoría
    public List<String> CantProfesores() {
        List<String> categorias = new ArrayList<>();
        Node current = head;
        while (current != null) {
            String categoria = current.profesor.categoriaDocente;
            if (!categorias.contains(categoria)) {
                categorias.add(categoria);
            }
            current = current.next;
        }
        Collections.sort(categorias);
        List<String> cantProfesores = new ArrayList<>();
        for (String categoria : categorias) {
            int count = 0;
            Node node = head;
            while (node != null) {
                if (node.profesor.categoriaDocente.equals(categoria)) {
                    count++;
                }
                node = node.next;
            }
            cantProfesores.add(categoria + ": " + count);
        }
        return cantProfesores;
    }

    // Método MostrarLista: Muestra la lista ordenada por edad
    public List<String> MostrarLista() {
        List<String> listaProfesores = new ArrayList<>();
        Node current = head;
        while (current != null) {
            listaProfesores.add(current.profesor.toString());
            current = current.next;
        }
        Collections.sort(listaProfesores, new Comparator<String>() {
            @Override
            public int compare(String p1, String p2) {
                return Integer.compare(p1.split(", ")[1].split(": ")[1], p2.split(", ")[1].split(": ")[1]);
            }
        });
        return listaProfesores;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Estudiante {
    String ci;
    String nombre;
    String apellido;
    String sexo;
    int año;
    boolean esMilitante;
    boolean esBecado;

    Estudiante(String ci, String nombre, String apellido, String sexo, int año, boolean esMilitante, boolean esBecado) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.año = año;
        this.esMilitante = esMilitante;
        this.esBecado = esBecado;
    }

    @Override
    public String toString() {
        return "CI: " + ci + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Sexo: " + sexo + ", Año: " + año + ", Militante: " + esMilitante + ", Becado: " + esBecado;
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

    // Método Cumpleaños: Devuelve nombres de estudiantes que cumplen años en enero
    public List<String> Cumpleaños() {
        List<String> cumplenAniosEnero = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.estudiante.año == 2023 && current.estudiante.nombre.split(" ")[1].equals("Enero")) {
                cumplenAniosEnero.add(current.estudiante.nombre);
            }
            current = current.next;
        }
        return cumplenAniosEnero;
    }

    // Método CantMilitantes: Devuelve listado de estudiantes militantes de la UJC
    public List<String> CantMilitantes() {
        List<String> estudiantesMilitantes = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.estudiante.esMilitante) {
                estudiantesMilitantes.add(current.estudiante.toString());
            }
            current = current.next;
        }
        return estudiantesMilitantes;
    }

    // Método CantBecados: Devuelve cantidad de estudiantes becados
    public int CantBecados() {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.estudiante.esBecado) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    // Método MostrarLista: Muestra la lista ordenada por año
    public List<String> MostrarLista() {
        List<String> listaEstudiantes = new ArrayList<>();
        Node current = head;
        while (current != null) {
            listaEstudiantes.add(current.estudiante.toString());
            current = current.next;
        }
        Collections.sort(listaEstudiantes, new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                return Integer.compare(e1.split(", ")[1].split(": ")[1], e2.split(", ")[1].split(": ")[1]);
            }
        });
        return listaEstudiantes;
    }
}

import java.util.ArrayList;
import java.util.List;

class Empleado {
    String nombre;
    String departamento;

    Empleado(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Departamento: " + departamento;
    }
}

class ListaDepartamentos {
    private Node head;

    private class Node {
        Empleado empleado;
        Node next;

        Node(Empleado empleado) {
            this.empleado = empleado;
            this.next = null;
        }
    }

    // Método para agregar un departamento a la lista
    public void addDepartamento(String nombre) {
        Node newNode = new Node(new Empleado("Depósito", nombre));
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

    // Método MostrarDepartamentos: Muestra la lista de departamentos
    public List<String> MostrarDepartamentos() {
        List<String> departamentos = new ArrayList<>();
        Node current = head;
        while (current != null) {
            departamentos.add(current.empleado.departamento);
            current = current.next;
        }
        return departamentos;
    }

    // Método ListarEmpleados: Lista empleados de un departamento específico
    public List<String> ListarEmpleados(String departamento) {
        List<String> empleados = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.empleado.departamento.equals(departamento)) {
                empleados.add(current.empleado.toString());
            }
            current = current.next;
        }
        return empleados;
    }
}
```

## Casos de Errores

- Agregar Profesores con Edad Repetida
```java
ListaProfesores lista = new ListaProfesores();
lista.addProfesor(new Profesor("Juan", 30, "Titular"));
lista.addProfesor(new Profesor("Ana", 30, "Jefe"));
System.out.println(lista.MostrarLista());
```

- Agregar Profesores con Edad Superior a 26 y Categoría Diferente a "Titular"
```java 
lista.addProfesor(new Profesor("Pedro", 27, "Asistente"));
System.out.println(lista.ProxCambio());
```

- Mostrar Lista de Profesores 
```java
System.out.println(lista.MostrarLista());
```

- CantProfesores sin Profesores:
```java
System.out.println(lista.CantProfesores());
```

## Casos de Prueba
- Agregar Profesores con Diferentes Edades y Categorías:
```java
lista.addProfesor(new Profesor("Juan", 30, "Titular"));
lista.addProfesor(new Profesor("Ana", 25, "Jefe"));
lista.addProfesor(new Profesor("Pedro", 35, "Asistente"));
System.out.println(lista.MostrarLista());

```
- Agregar Profesores con Edad Superior a 26 y Categoría Diferente a "Titular":
```java
lista.addProfesor(new Profesor("María", 27, "Asistente"));
System.out.println(lista.ProxCambio());
```
- Mostrar Lista con Profesores:
```java
System.out.println(lista.MostrarLista());
```
- CantProfesores con Profesores:
```java 
System.out.println(lista.CantProfesores());
```
