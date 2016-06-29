/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.HiloChats;
import Modelo.HiloDifusion;
import Modelo.Servidor;
import Vista.VentanaChat;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;


/**
 *
 * @author viccr
 */
public class ControladorPrincipal implements ActionListener{
    private VentanaPrincipal ventana;
    private Socket socket;
    private HiloDifusion hiloC;
    private HiloChats hilochat;
    private Servidor server;
    
    public ControladorPrincipal(VentanaPrincipal ventana,Servidor server){
        this.ventana = ventana;
        this.server = server;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("CONECTAR") && ventana.setRadioDifusion()){
        //DIFUSION 
            VentanaChat chat = new VentanaChat("Difusion");
            chat.setVisible(true);
            String name = ventana.getNombre();
            String ip = ventana.getIP();
            int puerto = 8080;
            chat.setNombre(name);
            chat.setIP(ip);
            chat.setPuerto(Integer.toString(puerto));
             try {
                 socket = new Socket(chat.getIP(),chat.getPuerto());
                 chat.setSocket(socket);
                 hiloC = new HiloDifusion(chat, socket);
                 hiloC.start();
             } catch (Exception ex) {
                 System.out.println("Error en el conectar de chat difusion, controlador Principal");
             }
        }else  if(e.getActionCommand().equalsIgnoreCase("CONECTAR") && ventana.setRadioGrupal()){
            //GRUPAL
            VentanaChat chat = new VentanaChat("Grupal");
            chat.setVisible(true);
            
            String name = ventana.getNombre();
            String ip = ventana.getIP();
            int puerto = 8080;
            chat.setNombre(name);
            chat.setIP(ip);
            chat.setPuerto(Integer.toString(puerto));
            
            try {
                 socket = new Socket(chat.getIP(),chat.getPuerto());
                 chat.setSocket(socket);
                 hilochat = new HiloChats(chat, socket);
                 hilochat.start();
             } catch (Exception ex) {
                 System.out.println("Error en el conectar de chat grupal, controlador Principal");
             }
        }else  if(e.getActionCommand().equalsIgnoreCase("CONECTAR") && ventana.setRadioPrivado()){
            //PRIVADO
            VentanaChat chat = new VentanaChat("Privado");
            chat.setVisible(true);
            
            String name = ventana.getNombre();
            String ip = ventana.getIP();
            int puerto = 8080;
            chat.setNombre(name);
            chat.setIP(ip);
            chat.setPuerto(Integer.toString(puerto));
            
            try {
                 socket = new Socket(chat.getIP(),chat.getPuerto());
                 chat.setSocket(socket);
                 hilochat = new HiloChats(chat, socket);
                 hilochat.start();
             } catch (Exception ex) {
                 System.out.println("Error en el conectar de chat privado, controlador Principal");
             }
        }
    }
     public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
