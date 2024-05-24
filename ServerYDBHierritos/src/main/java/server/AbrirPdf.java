package server;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AbrirPdf {
    public static void abrirPdf(String nombrePdf){
        try {
            // Especifica la ubicación y el nombre del archivo PDF que deseas abrir
            String nombrePDF = nombrePdf+".pdf"; // Reemplaza con la ubicación y el nombre de tu archivo PDF

            // Crea un objeto File con la ubicación del archivo PDF
            File pdfFile = new File(nombrePDF);

            // Verifica si el sistema admite la funcionalidad de Desktop
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (pdfFile.exists()) {
                    // Abre el archivo PDF con la aplicación predeterminada
                    desktop.open(pdfFile);
                } else {
                    System.out.println("El archivo PDF no existe.");
                }
            } else {
                System.out.println("La funcionalidad de Desktop no está soportada en este sistema.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
