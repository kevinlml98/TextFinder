package textfinder.panellateral;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import textfinder.showResults.VisorDocument;

import java.io.File;

public class nodo {

    //_______________________ Atributos de lo elementos que se incluirán en la biblioteca
    nodo nextNodo;
    private String documentType;
    private String documentName;
    private String documentSize;
    private String documentURL;
    Button button = new Button();


    //______________________ Método constuctor

    public nodo(){

    }

    public nodo(File file) {
        String description = file.toString();
        int StringLength = description.length();
        int name = file.getName().length();
        String subname = file.getName().substring(0,name - 4);
        String substring = description.substring(StringLength - 3 , StringLength);

        documentType = substring; //_____ Se defne el tipo de archivo
        documentName = subname;
        documentURL = file.toString();
        makeButton();
    }



    //______________________ Gráficos
    private void makeButton (){

        //__________ Crear boton _______//
        button.setText(documentName);
        button.setPrefWidth(120);
        button.setPrefHeight(100);
        Image image = new Image(getClass().getResourceAsStream("iconFolder2.png"));
        button.setGraphic(new ImageView(image));
        button.setContentDisplay(ContentDisplay.TOP);

        //____________ Acción al clickear
        button.setOnAction(
                (event) -> {
                    VisorDocument visor = new VisorDocument();
                    visor.GraphicVisor(documentURL,documentName);
                }
        );

    }





    //___________________ Getters and Setters

}
