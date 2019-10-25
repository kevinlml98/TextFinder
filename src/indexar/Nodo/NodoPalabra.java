package indexar.Nodo;

public class NodoPalabra {

    //_______ Atributos
    public String palabra = "";
    private NodoPalabra nodoLeft;
    private NodoPalabra nodoRight;
    private String library = "";




    //________ Método Constructor
    public NodoPalabra(){
        System.out.println("Nodo raiz añadido");

    }

    public NodoPalabra(String palabra){
        this.palabra = palabra;
    }


    //____________ Añadir Palabra
    public void addWord(String palabra, String libro){

        int i = this.palabra.compareTo(palabra); // ______ Compara la palabra del nodo con palabras

        if(i > 0){
            if (nodoLeft == null){
                NodoPalabra n = new NodoPalabra(palabra);
                nodoLeft = n;
                nodoLeft.addWord(palabra,libro);
            }else{
                nodoLeft.addWord(palabra,libro);
            }

        }else if(i < 0){
            if (nodoRight == null){
                NodoPalabra n = new NodoPalabra(palabra);
                nodoRight = n;
                nodoRight.addWord(palabra,libro);
            }else{
                nodoRight.addWord(palabra,libro);
            }
        }else {
            addBook(libro);
        }
    }

    //__________________ Añadir libro al nodo
    private void addBook(String libro){
        if(!library.contains(libro)) {
            this.library += libro + ",";
            System.out.println("Libreria " + this.library + " añadida al nodo " + this.palabra);
        }else{
            System.out.println("La liberia: " + this.library + " ; ya está añadida al nodo " + this.palabra);
        }

    }

    //___________________ Leer Libro
    public String returnBook(String titulo){

        String[] book = library.split(",");

        for (int i = 0; i < book.length; i++) {

            if (book[i].contains(titulo) == true){
                return book[i];
            }

            System.out.println(book[i]);
        }

        return titulo + " no encontrado";
    }

    //______________________ Getters and Setters
    public String getLibrary() {
        return library;
    }

    public NodoPalabra getNodoLeft() {
        return nodoLeft;
    }

    public NodoPalabra getNodoRight() {
        return nodoRight;
    }
}
