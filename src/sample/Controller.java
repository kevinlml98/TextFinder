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
import textfinder.panellateral.PanelLateral;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //____________________________________________  Implementaciones
    OptionMenu fileSettings = new OptionMenu();
    PanelLateral panelLateral = new PanelLateral();


    //_____________________________________________ Atributos



    //____________________________________________ Botones de hoja FXML
    @FXML
    private MenuItem optWord;

    @FXML
    private MenuItem optName;

    @FXML
    private Button btnopt;

    @FXML
    private Button btnsearch;

    @FXML
    private MenuItem optSize;

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

    @FXML
    private MenuItem optText;



    //_______________________________________________________ Boton que abre el menu de obciones
    @FXML
    void menuSettings(MouseEvent event) {
        fileSettings.btnSettings();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Bienvenido a TextFinder");
        panelLateral.addMutualElements(VBOXpanel);
        fileSettings.addMutualElements(panelLateral);


    }
}
