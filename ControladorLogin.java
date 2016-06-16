//he editado este archivo

package Controladores;

import Modelos.Musica;
import Modelos.Usuario;
import Vistas.VistaLogin;
import Vistas.VistaMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;

public class ControladorLogin implements ActionListener{
    
    public VistaLogin LoginV;
    public Usuario UsuarioV;
    private int IntentosFallidos = 0;
    private ControladorRegistrarse RegV;
    
    public ControladorLogin() throws InterruptedException, FileNotFoundException, JavaLayerException{
        LoginV = new VistaLogin();
        LoginV.setVisible(true);
        LoginV.agregarListener(this);
        Musica.reproducirBGM("MainBGM");
    }
    
    public void botonIngresar(){
        try {
            String Username = LoginV.getUsername();
            String password = LoginV.getPassword();
            int LGContrasena = password.length();
            int LGUsuario = Username.length();
            String LoginString = Username+" "+password;
            boolean booleano;
            if (LGUsuario < 1){
                JOptionPane.showMessageDialog(LoginV, "Nombre de Usuario en Blanco");}
            else if ( LGContrasena < 1){
                JOptionPane.showMessageDialog(LoginV, "Contraseña en Blanco");}
            else if ( (booleano = Usuario.VerificarDatos(LoginString,true))){
                UsuarioV = new Usuario();
                UsuarioV.setUsuario(Username);
                UsuarioV.setContrasena(password);
                JOptionPane.showMessageDialog(LoginV, "Login Existoso");
                VistaMenuPrincipal MenuPrincipal= new VistaMenuPrincipal();
                MenuPrincipal.setVisible(true);
                LoginV.dispose();
            }
            else{
                JOptionPane.showMessageDialog(LoginV, "Datos Incorrectos");
                IntentosFallidos+=1;
                if (IntentosFallidos == 5){
                    LoginV.dispose();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }

    public void botonRegistrate() {
        RegV = new ControladorRegistrarse();
        
        LoginV.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==LoginV.getBotonIngresar()){
            botonIngresar();
        }
        if(ae.getSource()==LoginV.getBotonRegistarse()){
            botonRegistrate();
        }
        
    }
}

