package textfinder.Documents.OpenPDF;

import java.io.File;
import java.io.FileWriter;

public class mainOpenPDF {
    //___________________________ Atributos



    //__________________________ Método Contructor
    public void mainOpenPDF (){
    }


    //__________________________ Leer un archivo PDF
    public void readPDF(String pdfFile){
        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath(pdfFile);
        try {
            String text = pdfManager.toText();
            convertPdfToTxt(pdfFile,text);
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }

    }

    //_______________________________ Convertir documentos pdf a txt
    private void convertPdfToTxt (String fileName,String texto){
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