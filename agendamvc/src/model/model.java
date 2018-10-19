/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Dani
 */
public class model {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String nombre;
    private String email;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base agenda_mvc.
     * 2.- Consulta todo los registros de la tabla contactos.
     * 3.- Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public Connection conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_mvc", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            nombre = rs.getString("nombre");
            email = rs.getString("email");
            telefono = rs.getString("telefono");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error en el model de conexion: " + err.getMessage());
        }
        return conexion; //retorna la variable conexion

    }
    
    
    public void moverPrimerRegistro() throws SQLException{
        System.out.print("Amigo tu boton primer registro funciona");
        rs.first();
        this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
        this.setTelefono(rs.getString("telefono"));
    }
    
   
    public void moverSiguienteRegistro() throws SQLException{
        System.out.print("Amigo tu boton siguiente registro funciona");
        if (!rs.isLast()){
            rs.next();
    }
        this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
        this.setTelefono(rs.getString("telefono"));
    }
    
  
    public void moverAnteriorRegistro() throws SQLException{
        System.out.print("Amigo tu boton anterior registro funciona");
        if (!rs.isFirst()){
            rs.previous();
    }
        this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
        this.setTelefono(rs.getString("telefono"));
    }
    
    public void moverUltimoRegistro() throws SQLException{
        System.out.print("Programa accion moverUltimoRegistro");
        rs.last();
            this.setNombre(rs.getString("nombre"));
            this.setEmail(rs.getString("email"));
            this.setTelefono(rs.getString("telefono"));
    }
    
    /////Acciones de botones 
    public void nuevo() throws SQLException{
        System.out.print("El de nuevo funciona");
        
    }
    public void insertar(String nombre,String email,String telefono){
        try {
                System.out.print("El boton insertar funciona");
                conexion = null;
                conexion = conectarDB();
                ps = conexion.prepareStatement("INSERT INTO contactos (nombre, email, telefono) VALUES (?,?,?)");//guarda los datos y prepara la consulta
                ps.setString(1 , nombre );//envia los datps a insertar de la consulta en la columna 1
                ps.setString(2, email);
                ps.setString(3, telefono);
                int resultado = ps.executeUpdate();//ejecuta la inserccion dde sql y lo guarda en resultado
                if (resultado != 0) {//si si se actualizo devuelve un numero diferente a 0
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                }else{
                    JOptionPane.showMessageDialog(null, "El registro no se inserto correctamente");
                }     
                this.conectarDB();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error-insertar"+ e.getMessage());
        }
        
    }
    public void modificar(String nombre,String email,String telefono) throws SQLException{
        System.out.print("El boton modificar funciona");
        String actualEmail = this.getEmail();
        String actualTelefono = this.getTelefono();
        st.executeUpdate("UPDATE contactos SET nombre='" + nombre + "',email='" + email + "' , email='" + actualEmail + "',telefono='" + telefono + "' WHERE telefono='" + actualTelefono + "' ;");
        this.conectarDB();
    }

    public void eliminar(String email) throws SQLException {
        System.out.print("El boton eliminar eliminar");
        st.executeUpdate("DELETE FROM contactos WHERE email='" + email + "';"); 
        this.conectarDB();
    }

    
     
   }
