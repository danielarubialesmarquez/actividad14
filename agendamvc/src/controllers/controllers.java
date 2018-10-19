/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model;
import view.view;

/**
 *
 * @author Dani
 */
public class controllers {
    
    model model;
    view view;
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.jbtn_primero) {
                try {
                    jbtn_primero_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view.jbtn_anterior) {
                try {
                    jbtn_anterior_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view.jbtn_siguiente) {
                try {
                    jbtn_siguiente_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view.jbtn_ultimo) {
                try {
                    jbtn_ultimo_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (e.getSource() == view.jb_nuevo){
                try{
                    jb_nuevo_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (e.getSource() == view.jb_insertar){
                jb_insertar_actionPerformed();
            }else if (e.getSource() == view.jb_modificar){
                try{
                    jb_modificar_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }  
            
            }else if (e.getSource() == view.jb_eliminar){
                try{
                    jb_eliminar_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            }

        

    };
//4
   
    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param model objeto de tipo Model
     * @param view objeto de tipo View
     */
    public controllers(model model, view view) {
        this.model = model;
        this.view = view;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        model.conectarDB();
        view.jtf_nombre.setText(model.getNombre());
        view.jtf_email.setText(model.getEmail());
        view.jtf_telefono.setText(model.getTelefono());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        view.setLocationRelativeTo(null);
        view.setTitle("Agenda que conecta a la base de datos MVC");
        view.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        view.jbtn_primero.addActionListener(actionListener);
        view.jbtn_anterior.addActionListener(actionListener);
        view.jbtn_siguiente.addActionListener(actionListener);
        view.jbtn_ultimo.addActionListener(actionListener);
        view.jb_nuevo.addActionListener(actionListener);
        view.jb_modificar.addActionListener(actionListener);
        view.jb_eliminar.addActionListener(actionListener);
        view.jb_insertar.addActionListener(actionListener);
        
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_primero");
        model.moverPrimerRegistro();//invocar al metodo moverPrimerRegistro
        view.jtf_nombre.setText(model.getNombre());//mostrar nombre en la vista
        view.jtf_email.setText(model.getEmail());//mostar email en la vista
        view.jtf_telefono.setText(model.getTelefono());// mostar telefono en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_anterior");
         model.moverAnteriorRegistro();//invocar al metodo moverPrimerRegistro
        view.jtf_nombre.setText(model.getNombre());//mostrar nombre en la vista
        view.jtf_email.setText(model.getEmail());//mostar email en la vista
        view.jtf_telefono.setText(model.getTelefono());//mostrar telefonoen la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_ultimo");
        model.moverUltimoRegistro();//invocar al metodo moverPrimerRegistro
        view.jtf_nombre.setText(model.getNombre());//mostrar nombre en la vista
        view.jtf_email.setText(model.getEmail());//mostar email en la vista
        view.jtf_telefono.setText(model.getTelefono());//mostrar telefono en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_siguiente");
         model.moverSiguienteRegistro();//invocar al metodo moverPrimerRegistro
        view.jtf_nombre.setText(model.getNombre());//mostrar nombre en la vista
        view.jtf_email.setText(model.getEmail());//mostar email en la vista
        view.jtf_telefono.setText(model.getTelefono());
    }
    /**
     * 
     * metodo de botones de nuvo, insertar,modificar y eliminar
     */
   private void jb_nuevo_actionPerformed() throws SQLException{
       System.out.println("Action del boton jb_nuevo");
       model.setEmail(null);//pone el jtfemail vacio
       model.setNombre(null);//pone el jtfnombre vacio
       model.setTelefono(null);
       model.nuevo();//invocara al nuevo registro que quiera realizar
       view.jtf_email.setText(model.getEmail());//permite modificar y reconocer el texto
       view.jtf_nombre.setText(model.getNombre()); //permite modificar y reconocer el texto
       view.jtf_telefono.setText(model.getTelefono());// permite modoficar y reconocer el texto
   }
   private void jb_insertar_actionPerformed(){
       System.out.println("Action del boton insertar");
       model.setNombre(view.jtf_nombre.getText());//llena el campo de nombre
       model.setEmail(view.jtf_email.getText());//llena el campo de email
       model.setTelefono(view.jtf_telefono.getText());
       model.insertar(model.getNombre(),model.getEmail(), model.getTelefono());//Guarda el registro
       
   }
   private void jb_modificar_actionPerformed() throws SQLException{
       
       model.modificar(view.jtf_nombre.getText(), view.jtf_email.getText(), view.jtf_telefono.getText());
       JOptionPane.showMessageDialog(view," Tu registro ha sido modificado ");
   }
   private void jb_eliminar_actionPerformed() throws SQLException{
       System.out.println("Action del boton eliminar");
            System.out.println(model.getEmail());
            model.eliminar(model.getEmail());
            JOptionPane.showMessageDialog(view, "Advertencia tu registro se ha eliminado "); 
            
   }
}
