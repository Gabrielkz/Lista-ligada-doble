class listaDoble {
    private Nodo head;
    private Nodo tail;

    public listaDoble() {
        this.head = null; 
        this.tail = null;
    }

    public void insert(int key) {
        Nodo newNodo = new Nodo(key);

        if (head == null) {
            // Si la lista está vacía, el nuevo nodo es tanto la cabeza como la cola
            head = newNodo;
            tail = newNodo;
        } else {
            // Si la lista no está vacía, ajustamos los punteros next y prev
            newNodo.next = head;
            head.prev = newNodo;
            head = newNodo;
        }
    }

    public void displayForward() {
        Nodo current = head;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Nodo current = tail;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Método para buscar un nodo por el valor de su campo clave y devolver una referencia
    public Nodo searchByKey(int key) {
        Nodo current = head;
        while (current != null && current.key != key) {
            current = current.next;
        }
        return current;
    }

    // Método para buscar un nodo por su campo clave e insertar un nuevo nodo después de él
    public void insertAfter(int key, int newKey) {
        Nodo current = searchByKey(key);
        if (current != null) {
            Nodo newNodo = new Nodo(newKey);
            newNodo.next = current.next;
            newNodo.prev = current;
            if (current.next != null) {
                current.next.prev = newNodo;
            }
            current.next = newNodo;
        }
    }

    // Método para intercambiar un nodo por otro buscado
    public void swapNodes(int key1, int key2) {
        if (key1 == key2) {
            return;
        }

        Nodo nodo1 = searchByKey(key1);
        Nodo nodo2 = searchByKey(key2);

        if (nodo1 == null || nodo2 == null) {
            return; // Al menos una clave no fue encontrada
        }

        // Intercambiar punteros next
        Nodo tempNext = nodo1.next;
        nodo1.next = nodo2.next;
        nodo2.next = tempNext;

        // Intercambiar punteros prev
        Nodo tempPrev = nodo1.prev;
        nodo1.prev = nodo2.prev;
        nodo2.prev = tempPrev;

        // Actualizar punteros prev de los nodos adyacentes
        if (nodo1.next != null) {
            nodo1.next.prev = nodo1;
        }

        if (nodo2.next != null) {
            nodo2.next.prev = nodo2;
        }

        if (nodo1.prev != null) {
            nodo1.prev.next = nodo1;
        } else {
            // Si node1 era la cabeza, actualizamos la cabeza
            head = nodo1;
        }

        if (nodo2.prev != null) {
            nodo2.prev.next = nodo2;
        } else {
            // Si node2 era la cabeza, actualizamos la cabeza
            head = nodo2;
        }
    }
}