public class Main {
    public static void main(String[] args) {
        listaDoble listaDoble = new listaDoble();

        listaDoble.insert(3);
        listaDoble.insert(7);
        listaDoble.insert(1);
        listaDoble.insert(5);

        System.out.println("Lista doble enlazada hacia adelante:");
        listaDoble.displayForward();

        System.out.println("Lista doble enlazada hacia atrás:");
        listaDoble.displayBackward();

        int searchKey = 1;
        Nodo foundNodo = listaDoble.searchByKey(searchKey);
        System.out.println("Nodo con clave " + searchKey + " encontrado: " + (foundNodo != null));

        int insertKey = 7;
        int newKey = 10;
        listaDoble.insertAfter(insertKey, newKey);
        System.out.println("Lista después de insertar " + newKey + " después de " + insertKey + ":");
        listaDoble.displayForward();

        int key1 = 5;
        int key2 = 3;
        listaDoble.swapNodes(key1, key2);
        System.out.println("Lista después de intercambiar nodos con claves " + key1 + " y " + key2 + ":");
        listaDoble.displayForward();
    }
}