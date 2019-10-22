package indexar.Parcear;

import indexar.Nodo.NodoPalabra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Indexar {

    //______________ Atributos e inicialización
    NodoPalabra nodo = new NodoPalabra();



    //______________ Método constructor
    public Indexar(){
    }



    //_________________ Indexar documentos

    public void IndexarDocumentos (){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/textfinder/panellateral/Library.txt"));
            String line ;

            while ((line = reader.readLine()) != null) {
                Parsear(line);
            }
            reader.close();
            System.out.println("Indexación finalizada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //________________ Leer palabra por palabra  para ir indexando el documento
    private void Parsear (String line)  {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(line));
            String oracion;

            while ((oracion = reader.readLine()) != null) {
                String[] linea = oracion.split("\\s+");
                for (int i = 0; i < linea.length; i++) {
                    nodo.addWord(linea[i],line);
                }

            }
            System.out.println(line + " Indexado exitosamente");
            reader.close();

        }catch (IOException e){
            System.out.println("Error al indexar: " + line);
           // e.printStackTrace();
        }


    }



}
