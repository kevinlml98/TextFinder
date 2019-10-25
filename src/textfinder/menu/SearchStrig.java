package textfinder.menu;

import indexar.Nodo.NodoPalabra;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import textfinder.showResults.VisorDocument;


public class SearchStrig {
    //_____________________________ Atributos
    OptionMenu optionMenu;
    VBox resultPane;


    //______________________________ Añadir elementos mutuos
    public void addMutualElements(OptionMenu optionMenu, VBox resultPane){
        this.optionMenu = optionMenu;
        this.resultPane = resultPane;
    }


    //______________________________ Método constructor
    public SearchStrig(){
    }



    //_______________________________ Busqueda de Palabras
    public void searchWord(String palabras){

        resultPane.getChildren().clear();
        String[] arrayOracion = palabras.split("\\s+");
        for (int i = 0; i < arrayOracion.length; i++) {
            NodoPalabra temp = optionMenu.indexar.getNodo();
            System.out.println(arrayOracion[i] + " ubicado en " + findBookOnNode(arrayOracion[i],temp));
        }
        System.out.println("Proceso terminado");
    }



    //________________________________ Buscar en nodos
    private String findBookOnNode(String name, NodoPalabra temp) {
        if (temp == null){
            return "Ninguna librería";
        }else if(temp.palabra.compareTo(name) == 0){
            showResults(name,temp.getLibrary());
            return temp.getLibrary();
        }else if(temp.palabra.compareTo(name) > 0){
            return findBookOnNode(name, temp.getNodoLeft());
        }else if(temp.palabra.compareTo(name) < 0){
            return findBookOnNode(name, temp.getNodoRight());
        }
        return "Error en el proceso. No compara correctamente los nodos";

    }

    //_______________________________ Añadir los resultados al panel de resultados
    private void showResults(String nombre, String direccion){
        //____ Bucle para añadir todos los resultados en el Vbox

        Button button = new Button(nombre);
        button.setPrefWidth(120);
        button.setPrefHeight(100);

        String[] URL = direccion.split(",");

        //____________ Acción al clickear
        button.setOnAction(
                (event) -> {
                    VisorDocument visor = new VisorDocument();
                    visor.GraphicVisor(URL[0],nombre);
                }
        );


        Label label = new Label(direccion);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(button,label);
        hBox.setPrefHeight(100);
        hBox.setPrefWidth(1000);
        resultPane.getChildren().add(hBox);

    }

}
