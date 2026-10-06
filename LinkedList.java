import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Función para eliminar duplicados
    public void removeDuplicates() {
        Set<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                // Eliminar el nodo actual
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    // Función para rotar a la derecha en una posición
    public void rotateRight(int k) {
        if (head == null || head.next == null || k == 0) {
            return;
        }

        Node last = head;
        int n = 1;

        // Encuentra el último nodo y el n-k-ésimo nodo
        while (last.next != null) {
            last = last.next;
            n++;
        }

        Node kthLast = head;
        for (int i = 1; i < n - k; i++) {
            kthLast = kthLast.next;
        }

        // Rotar la lista
        last.next = head;
        head = kthLast.next;
        kthLast.next = null;
    }

    // Función para concatenar dos listas
    public void concatenate(LinkedList list2) {
        if (head == null) {
            head = list2.head;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = list2.head;
        }
    }
}
