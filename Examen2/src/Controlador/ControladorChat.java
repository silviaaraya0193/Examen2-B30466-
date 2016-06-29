/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CryptSecurity;
import Vista.VentanaChat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viccr
 */
public class ControladorChat implements ActionListener{
    private VentanaChat ventana;
    private DataOutputStream salida;
    private CryptSecurity cifrador;
    
    public ControladorChat(VentanaChat ventana){
        this.ventana = ventana;
        cifrador = new CryptSecurity();
    }
     public Socket getSocket(){
        return ventana.getSocket();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("ENVIAR")){
            if(getSocket() != null){
                if(ventana.validarMensaje()){
                    try {
                        String msj=ventana.getMensajeCifrado(ventana.getTipoChat());
                        salida = new DataOutputStream(getSocket().getOutputStream());
                        ventana.setMensajeDescifrado(msj);
                        salida.writeUTF(msj);
                        ventana.limpiarMensaje();
                        
                    } catch (IOException ex) {
                        System.out.println("Error en el enviar del controlador chat");
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorChat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }else if(e.getActionCommand().equalsIgnoreCase("SALIR")){
            System.exit(0);
        }
    }
    
}
