/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPrincipal;
import Modelo.Servidor;
import javax.swing.ButtonGroup;

/**
 *
 * @author viccr
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    private Servidor server;
    private static int valor;
    
    public VentanaPrincipal() {
        initComponents();
        ControladorPrincipal controladorP = new ControladorPrincipal(this,server);
        setActionCommand(controladorP);
        ButtonGroup group = new ButtonGroup();
        group.add(radio_difusion);
        group.add(radio_grupal);
        group.add(radio_privado);
        //valor = Integer.parseInt(txt_puerto.getText());
        this.setLocationRelativeTo(null);
    }

    private void setActionCommand(ControladorPrincipal controladorP) {
//        radio_difusion.addActionListener(controladorP);
//        radio_grupal.addActionListener(controladorP);
//        radio_privado.addActionListener(controladorP);
        btn_conectar.addActionListener(controladorP);
    }

    public boolean setRadioDifusion() {
        if (radio_difusion.isSelected()) {
            return true;
        }
        return false;
    }
     public boolean setRadioGrupal() {
        if (radio_grupal.isSelected()) {
            return true;
        }
        return false;
    }
      public boolean setRadioPrivado() {
        if (radio_privado.isSelected()) {
            return true;
        }
        return false;
    }
    public String getNombre() {
        return txt_usuario.getText();
    }

    public String getIP() {
        return txt_ip.getText();
    }
     
    public static int getPuerto() {
        
        return valor;
    }

    public void setNombre(String nombre) {
        this.txt_usuario.setText(nombre);
    }

    public void setIP(String ip) {
        this.txt_ip.setText(ip);
    }

    public void setPuerto(int puerto) {
        this.txt_puerto.setText(Integer.toString(puerto));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_ip = new javax.swing.JTextField();
        txt_puerto = new javax.swing.JTextField();
        radio_difusion = new javax.swing.JRadioButton();
        radio_grupal = new javax.swing.JRadioButton();
        radio_privado = new javax.swing.JRadioButton();
        btn_conectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Digite los datos solicitados para crear un nuevo cliente en el chat.");

        jLabel2.setText("Nombre Usuario:");

        jLabel3.setText("Direccion IP:");

        jLabel4.setText("Puerto:");

        radio_difusion.setText("Chat Difusion");

        radio_grupal.setText("Chat Grupal");

        radio_privado.setText("Chat Privado");

        btn_conectar.setText("CONECTAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_conectar)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txt_ip)
                            .addComponent(txt_puerto))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radio_difusion)
                            .addComponent(radio_grupal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radio_privado, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio_difusion))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio_grupal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio_privado))
                .addGap(52, 52, 52)
                .addComponent(btn_conectar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_conectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton radio_difusion;
    private javax.swing.JRadioButton radio_grupal;
    private javax.swing.JRadioButton radio_privado;
    private javax.swing.JTextField txt_ip;
    private javax.swing.JTextField txt_puerto;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
