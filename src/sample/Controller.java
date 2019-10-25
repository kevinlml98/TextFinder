package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import textfinder.menu.OptionMenu;
import textfinder.menu.SearchStrig;
import textfinder.panellateral.PanelLateral;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //____________________________________________  Implementaciones
    OptionMenu fileSettings = new OptionMenu();
    PanelLateral panelLateral = new PanelLateral();
    SearchStrig searchString = new SearchStrig();


    //_____________________________________________ Atributos



    //____________________________________________ Botones de hoja FXML
    @FXML
    private MenuItem optWord;

    @FXML
    private MenuItem optText;

    @FXML
    private MenuItem optName;

    @FXML
    private MenuItem optSize;

    @FXML
    private Button btnopt;

    @FXML
    private Button btnsearch;

    @FXML
    private HBox HBOXmenu;

    @FXML
    private SplitMenuButton btntype;

    @FXML
    private SplitMenuButton btnordenar;

    @FXML
    private TextField textSearch;

    @FXML
    private VBox VBOXresults;

    @FXML
    private VBox VBOXpanel;

    @FXML
    private BorderPane BPcontainer;





    //_______________________________________________________ Boton que abre el menu de obciones
    @FXML
    void menuSettings(MouseEvent event) {
        fileSettings.btnSettings();

    }

    //_______________________________________________________ Boton que abre el menu de obciones
    @FXML
    void searchText(MouseEvent event) {
        String search = textSearch.getText();
        if (search != null){
            searchString.searchWord(search);
            textSearch.clear();
        }else{
            System.out.println("No se ha ingresado texto");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Bienvenido a TextFinder");
        panelLateral.addMutualElements(VBOXpanel);
        fileSettings.addMutualElements(panelLateral);
        searchString.addMutualElements(fileSettings,VBOXresults);
        panelLateral.refreshPanel();


    }
}
