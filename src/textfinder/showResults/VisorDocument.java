package textfinder.showResults;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VisorDocument {

    //__________ TextFlow _______//
    TextFlow textFlow = new TextFlow();


    //____________ Método constructor __________//
    public void VisorDocument (){

    }


    //______________________ Método para añadir
    private void readInLibrary (String archivo){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                Text text = new Text(line);
                textFlow.getChildren().add(text);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //_____________ Graphic Square Visor _________//
    public void GraphicVisor (String archivo, String nombre){

        //___________________ Ejecutar la lectura de la libreria
        readInLibrary(archivo);

        //______ Stage _____//
        Stage stage = new Stage();

        //_______ Label ______ //
        Label label = new Label(nombre);
        label.setStyle("-fx-font-size: 20;");



        //__________ ScrollBar _______//
        //ScrollBar scrollBar = new ScrollBar();



        //______ Border Pane ____//
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(label);
        borderPane.setCenter(textFlow);
        borderPane.setPrefSize(600,500);


        //___________ Scene _____________//
        Scene scene = new Scene(borderPane);


        //________ Configuración del stage ______//
        stage.setScene(scene);
        stage.setTitle("Visualización");
        stage.show();

    }




}
