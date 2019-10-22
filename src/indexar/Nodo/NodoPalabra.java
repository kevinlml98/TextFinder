package indexar.Nodo;

import java.io.File;

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
    public void addWord(String palabra, File file){

        int i = this.palabra.compareTo(palabra); // ______ Compara la palabra del nodo con palabras

        if(i > 0){
            if (nodoLeft == null){
                NodoPalabra n = new NodoPalabra(palabra);
                nodoLeft = n;
                nodoLeft.addWord(palabra,file);
            }else{
                nodoLeft.addWord(palabra,file);
            }

        }else if(i < 0){
            if (nodoRight == null){
                NodoPalabra n = new NodoPalabra(palabra);
                nodoRight = n;
                nodoRight.addWord(palabra,file);
            }else{
                nodoRight.addWord(palabra,file);
            }
        }else {
            addBook(file);
        }
    }

    //__________________ Añadir libro al nodo
    private void addBook(File file){
        String archivo = file.toString() + ",";
        if(!library.contains(archivo)) {
            this.library += archivo;
            System.out.println("Libreria añadida al nodo");
        }else{
            System.out.println("La liberia ya está añadida al nodo");
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






}
