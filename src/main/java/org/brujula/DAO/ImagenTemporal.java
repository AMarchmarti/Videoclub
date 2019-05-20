package org.brujula.DAO;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ImagenTemporal {

    public static String guardarBlobEnFicheroTemporal(byte[] bytes, String nombreArchivo){
        String ubicacionImagen = null;

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("") + File.separatorChar + "resources" + File.separatorChar + "images"
                + File.separatorChar + nombreArchivo;

        File file = null;
        InputStream inputStream = null;

        try{
            file = new File(path);
            inputStream = new ByteArrayInputStream(bytes);
            FileOutputStream out = new FileOutputStream(file.getAbsolutePath());

            int c = 0;
            while ((c = inputStream.read()) >= 0){
                out.write(c);
            }

            out.flush();
            out.close();
            ubicacionImagen = "../../resources/images" + nombreArchivo;
        }catch (Exception e){
            System.err.println("No se pudo cargar la imagen");
        }

        return ubicacionImagen;
    }
}
