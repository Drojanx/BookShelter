package com.actividadaprendizaje.bookshelter.service;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Service para gestión de ficheros
 */
public interface FileService {

    void downloadFile(HttpServletResponse response, String listPurchases) throws IOException;
}
