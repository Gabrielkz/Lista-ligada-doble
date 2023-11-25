class Nodo {
    int key;
    Nodo next;
    Nodo prev; // Agregamos un puntero previo para la lista doble


    // Constructor para crear un nuevo nodo con una clave dada
    public Nodo(int key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}