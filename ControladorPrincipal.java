/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Musica;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
/**
 *
 * @author Eric Ramirez Santis
 */
public class ControladorPrincipal {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, JavaLayerException, IOException {
        Musica.cargarDatabase();
        new ControladorBatallaLibre();
    }
    
}
