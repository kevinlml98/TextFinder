package textfinder.Documents.OpenDOCX;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class DOCXManager {


    //______________________________ Método constructor
    public void DOCXManager(){
    }


    //_______________________________ Lector de documento
    public void readDOC(File archivo){
        try {
            FileInputStream fis = new FileInputStream(archivo.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            WordExtractor extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            for (int i = 0; i < fileData.length; i++)
            {
                if (fileData[i] != null)
                    convertDocToTxt(archivo.toString(),fileData[i]);
            }
        } catch (Exception exep) {
            exep.printStackTrace();
        }
    }




    //_______________________________ Convertir documentos doc a txt
    private void convertDocToTxt (String fileName,String texto){
        try {
            String ruta = fileName + ".txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado

            if (!file.exists()) {
                file.createNewFile();
            }

            //_______ Comienza la escritura en el nuevo archivo ________//
            FileWriter writer = new FileWriter(ruta, true);
            writer.append(texto);
            writer.append("\r\n");   // write new line
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
