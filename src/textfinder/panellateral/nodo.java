package textfinder.panellateral;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    public nodo(File file) {
        String description = file.toString();
        int StringLength = description.length();
        String substring = description.substring(StringLength - 3 , StringLength);

        documentType = substring; //_____ Se defne el tipo de archivo
        documentName = file.getName();
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
                    System.out.println("Boton de panel lateral precionado");
                }
        );

    }





    //___________________ Getters and Setters


}
