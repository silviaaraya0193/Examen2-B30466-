/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.HiloCliente;
import Modelo.Servidor;
import Vista.VentanaChat;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author viccr
 */
public class ControladorPrincipal implements ActionListener{
    private VentanaPrincipal ventana;
    private Socket socket;
    private HiloCliente hiloC;
    private Servidor server;
    
    public ControladorPrincipal(VentanaPrincipal ventana,Servidor server){
        this.ventana = ventana;
        this.server = server;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("CONECTAR") && ventana.setRadioDifusion()){
        //DIFUSION 
            VentanaChat chat = new VentanaChat();
            chat.setVisible(true);
            String name = ventana.getNombre();
            String ip = ventana.getIP();
            String puerto = ventana.getPuerto();
            chat.setNombre(name);
            chat.setIP(ip);
            chat.setPuerto(puerto);
             try {
                 socket = new Socket(chat.getIP(),chat.getPuerto());
                 chat.setSocket(socket);
                 hiloC = new HiloCliente(chat, socket);
                 hiloC.start();
             } catch (Exception ex) {
                 System.out.println("Error en el conectar de chat difusion, controlador Principal");
             }
        }else  if(e.getActionCommand().equalsIgnoreCase("CONECTAR") && ventana.setRadioGrupal()){
            //GRUPAL
            VentanaChat chat = new VentanaChat();
            chat.setVisible(true);
            
        }else  if(e.getActionCommand().equalsIgnoreCase("CONECTAR") && ventana.setRadioPrivado()){
            //PRIVADO
            VentanaChat chat = new VentanaChat();
            chat.setVisible(true);
            
        }
    }
     public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
