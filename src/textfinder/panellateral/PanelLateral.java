package textfinder.panellateral;


import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;

import java.io.*;

public class PanelLateral {
    //________________________ Implementaciones
    VBox vBoxGraphicPane = new VBox();
    ScrollBar sc = new ScrollBar();
    public nodo firstNode;



    //_____________________ Añadir elementos compartidos
    public void addMutualElements(VBox VBoxcointaner){
        this.vBoxGraphicPane = VBoxcointaner;
    }


    //________________________ Creación del método constructor
    public void PanelLateral(){
    }



    //_______________________ Añade el archivo a la librería library.txt
    public void writeInLibrary(String archivo){
        try {
            FileWriter writer = new FileWriter("src/textfinder/panellateral/Library.txt", true);
            String a = archivo.replace("\\","/");
            writer.write(a);
            writer.append("\r\n");   // write new line
            System.out.println("Documento agregado: " + a);
            writer.close();
        } catch (IOException e) {
            System.out.println("No se guardó el documento en la libreria");
            e.printStackTrace();
        }
    }


    //_________________________ Añadir nodo
    public void addNodo(File file){
        if(firstNode == null){
            nodo n = new nodo(file);
            firstNode = n;
            vBoxGraphicPane.getChildren().add(firstNode.button);
        }else{
            nodo n = new nodo(file);
            n.nextNodo = firstNode;
            firstNode = n;
            vBoxGraphicPane.getChildren().add(firstNode.button);
        }
    }

    public void refreshPanel (){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/textfinder/panellateral/Library.txt"));
            String line ;

            while ((line = reader.readLine()) != null) {
                if(line.contains("C")){
                    File file = new File(line);
                    addNodo(file);
                }
            }
            reader.close();
            System.out.println("Panel lateral actualizado");
        } catch (IOException e) {
            System.out.println("Panel lateral no actualizado");
            //e.printStackTrace();
        }
    }



    //___________________________ Añadir palabra al diccionario




}


