package textfinder.menu;


import indexar.Parcear.Indexar;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import textfinder.Documents.OpenDOCX.DOCXManager;
import textfinder.Documents.OpenPDF.mainOpenPDF;
import textfinder.panellateral.PanelLateral;

import java.io.File;

public class OptionMenu {


    //________________________ Implementaciones
    Indexar indexar = new Indexar();
    private PanelLateral panelLateral = new PanelLateral();



    //_____________________ Añadir elementos compartidos
    public void addMutualElements(PanelLateral panelLateral){
        this.panelLateral = panelLateral;
    }



    //________________________________ Menu de opciones, método constructor
    public void OptionMenu (){

    }


    //_______________________________ Añadir arhivos a la biblioteca
    private void addFile (Stage stage){
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select New Document");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Word", "*.doc"),
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("PDF", "*.pdf")

            );
            File file = fileChooser.showOpenDialog(stage);

            String description = file.toString();
            panelLateral.writeInLibrary(description + ".txt");
            panelLateral.addNodo(file); //_____________ Añade el nombre de la libreria al boton



            //________ Añadir el documento a la libreria ______//
            int StringLength = description.length();
            String substring = description.substring(StringLength - 3 , StringLength);
            if(substring.equals("doc")){
                DOCXManager leerDoc = new DOCXManager();
                leerDoc.readDOC(file);
            }else if(substring.equals("pdf")){
                mainOpenPDF leerPdf = new mainOpenPDF();
                leerPdf.readPDF(description);
            }else if(substring.equals("txt")){
                System.out.println("TXT AÑADIDO");
            } else {
                System.out.println("Formato no reconocido");
            }

        }catch (Exception e){
            System.out.println("Archivo no seleccionado");
        }

    }




    //__________________________________ Cuadro stage de menú de opciones
    public void btnSettings (){
        Stage settingsStage = new Stage();


        //____ Botones de opciones __ //
        Button btnAdd = new Button("Add File");
        Button btnRefresh = new Button ("Refresh");


        //_______________________________ Acciones de los botones

        btnAdd.setOnAction(
                (event) -> {
                    addFile(settingsStage);
                    settingsStage.close();
                }
        );

        btnRefresh.setOnAction(
                (event) -> {
                    indexar.IndexarDocumentos();
                    settingsStage.close();
                }
        );



        //_____ VBox contenedor de botones __//
        VBox VBOXbtncontainer = new VBox();
        VBOXbtncontainer.setAlignment(Pos.CENTER);
        VBOXbtncontainer.setStyle("-fx-border-color: blue");
        VBOXbtncontainer.getChildren().addAll(btnAdd,btnRefresh);


        //________ StackPane contenedor padre _____//


        StackPane stackPaneContainer = new StackPane();
        stackPaneContainer.getChildren().add(VBOXbtncontainer);

        //_________ Scene ______________//

        Scene sceneContainer = new Scene(stackPaneContainer,100,100);

        //____________ Stage Settings _____________//
        settingsStage.setTitle("Settings");
        settingsStage.setScene(sceneContainer);
        settingsStage.setResizable(false);
        settingsStage.resizableProperty().setValue(Boolean.FALSE);
        settingsStage.initStyle(StageStyle.UTILITY);
        settingsStage.show();

    }




}
