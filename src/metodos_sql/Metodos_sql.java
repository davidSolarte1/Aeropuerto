/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Solarte
 */
public class Metodos_sql {
    
    public static ConexionBD conexion = new ConexionBD();
    
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    
    public int guardar(String cedula, String nombres, String apellidos, String correo, String contraseña){
    
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar = ("INSERT INTO usuarios (cedula,nombres,apellidos,correo,contraseña) VALUES(?, ?, ?, ?, ?) ");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            
            sentencia_preparada.setString(1, cedula);
            sentencia_preparada.setString(2, nombres);
            sentencia_preparada.setString(3, apellidos);
            sentencia_preparada.setString(4, correo);
            sentencia_preparada.setString(5, contraseña);
            resultado = sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return resultado;
    }
    
    public int guardarcliente(String cedula, String nombre, String correo, String celular){
    
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar_cliente = ("INSERT INTO clientes (cedula,nombre,correo,celular) VALUES(?, ?, ?, ?) ");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar_cliente);
            
            sentencia_preparada.setString(1, cedula);
            sentencia_preparada.setString(2, nombre);
            sentencia_preparada.setString(3, correo);
            sentencia_preparada.setString(4, celular);
            resultado = sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return resultado;
    }
    
    public int guardarhangar(String idhangar, String numero, String altura, String ancho, String largo, String estado){
    
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar_hangar = ("INSERT INTO hangares (idhangar,numero,altura,ancho,largo,estado) VALUES(?, ?, ?, ?, ?, ?) ");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar_hangar);
            
            sentencia_preparada.setString(1, idhangar);
            sentencia_preparada.setString(2, numero);
            sentencia_preparada.setString(3, altura);
            sentencia_preparada.setString(4, ancho);
            sentencia_preparada.setString(5, largo);
            sentencia_preparada.setString(6, estado);
            resultado = sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return resultado;
    }
    
    public int guardaravionp(String id_avion, String puestos, String id_hangar){
    
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar_avion_p = ("INSERT INTO avionesp (id_avion,puestos,id_hangar) VALUES(?, ?, ?) ");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar_avion_p);
            
            sentencia_preparada.setString(1, id_avion);
            sentencia_preparada.setString(2, puestos);
            sentencia_preparada.setString(3, id_hangar);
            resultado = sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return resultado;
    }
       public int guardarvuelo(String id_vuelo, String id_avion, String tipo_avion, String salida, String llegada, String origen ,String destino,String estado){
    
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar_vuelo = ("INSERT INTO vuelos (id_vuelo,id_avion,tipo_avion,salida,llegada,origen,destino,estado) VALUES(?, ?, ?,?,?,?,?,?) ");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar_vuelo);
            
            sentencia_preparada.setString(1, id_vuelo);
            sentencia_preparada.setString(2, id_avion);
            sentencia_preparada.setString(3, tipo_avion);
            sentencia_preparada.setString(4, salida);
            sentencia_preparada.setString(5, llegada);
            sentencia_preparada.setString(6, origen);
            sentencia_preparada.setString(7, destino);
            sentencia_preparada.setString(8, estado);
            
            resultado = sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return resultado;
    }
    
    public int guardarasignacion(String vuelo, String cliente){
    
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar_vuelo_a = ("INSERT INTO vuelo_asignado (vuelo,cliente) VALUES(?, ?) ");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar_vuelo_a);
            
            sentencia_preparada.setString(1, vuelo);
            sentencia_preparada.setString(2, cliente);
            resultado = sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return resultado;
    }
    
    public int guardarfactura(String no_factura, String nom_cliente,String fecha_fact,String destino, String dia_salida, String dia_regreso, String cantidad, String valor_u, String valor_t){
    
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar_vuelo_a = ("INSERT INTO facturas (no_factura,nom_cliente,fecha_fact,destino,dia_salida,dia_regreso,cantidad,valor_u,valor_t) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar_vuelo_a);
            
            sentencia_preparada.setString(1, no_factura);
            sentencia_preparada.setString(2, nom_cliente);
            sentencia_preparada.setString(3, fecha_fact);
            sentencia_preparada.setString(4, destino);
            sentencia_preparada.setString(5, dia_salida);
            sentencia_preparada.setString(6, dia_regreso);
            sentencia_preparada.setString(7, cantidad);
            sentencia_preparada.setString(8, valor_u);
            sentencia_preparada.setString(9, valor_t);
            resultado = sentencia_preparada.executeUpdate();
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return resultado;
    }
    
    public void modificar(String cedula, String nombres, String apellidos, String correo, String contraseña){
    
      
        Connection conexion = null;
        
        String sentencia_modificar = ("UPDATE usuarios SET cedula=?,nombres=?,apellidos=?,correo=?,contraseña=? WHERE cedula = '"+cedula+"'");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_modificar);
            
            sentencia_preparada.setString(1, cedula);
            sentencia_preparada.setString(2, nombres);
            sentencia_preparada.setString(3, apellidos);
            sentencia_preparada.setString(4, correo);
            sentencia_preparada.setString(5, contraseña);
            
            sentencia_preparada.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos se han modificado \ncorrectamente");
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        
    }
    
    public void modificarcliente(String cedula, String nombre, String correo, String celular){
    
      
        Connection conexion = null;
        
        String sentencia_modificar_cliente = ("UPDATE clientes SET cedula=?,nombre=?,correo=?,celular=? WHERE cedula = '"+cedula+"'");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_modificar_cliente);
            
            sentencia_preparada.setString(1, cedula);
            sentencia_preparada.setString(2, nombre);
            sentencia_preparada.setString(3, correo);
            sentencia_preparada.setString(4, celular);
            
            sentencia_preparada.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos se han modificado \ncorrectamente");
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        
    }
    
    public void modificarhangar(String idhangar, String numero, String altura, String ancho, String largo, String estado){
    
      
        Connection conexion = null;
        
        String sentencia_modificar_hangar = ("UPDATE hangares SET idhangar=?,numero=?,altura=?,ancho=?,largo=?,estado=? WHERE idhangar = '"+idhangar+"'");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_modificar_hangar);
            
            sentencia_preparada.setString(1, idhangar);
            sentencia_preparada.setString(2, numero);
            sentencia_preparada.setString(3, altura);
            sentencia_preparada.setString(4, ancho);
            sentencia_preparada.setString(5, largo);
            sentencia_preparada.setString(6, estado);
            
            sentencia_preparada.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos se han modificado \ncorrectamente");
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        
    }
    public void modificaravionp(String id_avion, String puestos, String id_hangar){
    
      
        Connection conexion = null;
        
        String sentencia_modificar_hangar = ("UPDATE avionesp SET id_avion=?,puestos=?,id_hangar=? WHERE id_avion = '"+id_avion+"'");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_modificar_hangar);
            
            sentencia_preparada.setString(1, id_avion);
            sentencia_preparada.setString(2, puestos);
            sentencia_preparada.setString(3, id_hangar);
            
            sentencia_preparada.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos se han modificado \ncorrectamente");
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        
    }
    
     public void modificarvuelo(String id_vuelo, String id_avion, String tipo_avion, String salida, String llegada, String origen, String destino,String estado){
    
      
        Connection conexion = null;
        
        String sentencia_modificar = ("UPDATE vuelos SET id_vuelo=?,id_avion=?,tipo_avion=?,salida=?,llegada=?,origen=?,destino=?,estado=? WHERE id_vuelo = '"+id_vuelo+"'");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_modificar);
            
            sentencia_preparada.setString(1, id_vuelo);
            sentencia_preparada.setString(2, id_avion);
            sentencia_preparada.setString(3, tipo_avion);
            sentencia_preparada.setString(4, salida);
            sentencia_preparada.setString(5, llegada);
            sentencia_preparada.setString(6, origen);
            sentencia_preparada.setString(7, destino);
            sentencia_preparada.setString(8, estado);
            
            sentencia_preparada.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos se han modificado \ncorrectamente");
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        
    }

     
    
    public void borrar(String cedula, String nombres, String apellidos, String correo, String contraseña){
    
      
        Connection conexion = null;
        
        String sentencia_borrarusuario = ("DELETE FROM usuarios WHERE cedula = '"+cedula+"'");
        
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_borrarusuario);
            
            sentencia_preparada.setString(1, cedula);
            sentencia_preparada.setString(2, nombres);
            sentencia_preparada.setString(3, apellidos);
            sentencia_preparada.setString(4, correo);
            sentencia_preparada.setString(5, contraseña);
            
            sentencia_preparada.executeUpdate();
            JOptionPane.showMessageDialog(null, "El usuario se ha eliminado \ncorrectamente");
            
            sentencia_preparada.close();
            
        conexion.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        
    }
   
    
    
    public static String buscarNombre(String cedula){
        
        String busqueda_nombre = null;
        Connection conexion = null;
        
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT nombres,apellidos FROM usuarios WHERE cedula = '" + cedula + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            
            if(resultado.next()){
                String nombres = resultado.getString("nombres");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombres +" "+apellidos);
            }
            
            conexion.close();
        } 
        catch (Exception e) {
            
            System.out.println(e);
        }
        return busqueda_nombre;
    }
    
    /**
     *
     * @param cedula
     * @param contraseña
     * @return
     */
    public static String buscarUsuarioRegistrado (String cedula, String contraseña){
        String busqueda_usuario = null;
        Connection conexion = null;
        
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar_usuario = ("SELECT * FROM usuarios WHERE cedula = '"+cedula+"' && contraseña = '"+ contraseña +"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                busqueda_usuario = "Usuario Encontrado";
            } else{
                busqueda_usuario = "Ususario no encontrado";
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
        return busqueda_usuario;
    }
    
    public void consultar_id(JComboBox cbox_hangares){
        Connection conexion = null;
        String sentencia_buscar_hangar = ("SELECT idhangar FROM hangares WHERE estado = 'Libre' ORDER BY idhangar ");
        
        try {
            
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_hangar);
            ResultSet result =  sentencia_preparada.executeQuery();
            cbox_hangares.addItem("Seleccione Hangar");
            
            while(result.next()){
                cbox_hangares.addItem(result.getString("idhangar"));
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
    public void consultar_id_avion(JComboBox cbox_aviones){
        Connection conexion = null;
        String sentencia_buscar_avion = ("SELECT id_avion FROM avionesp ORDER BY id_avion");
        
        try {
            
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_avion);
            ResultSet result =  sentencia_preparada.executeQuery();
            cbox_aviones.addItem("Seleccione Avión");
            
            while(result.next()){
                cbox_aviones.addItem(result.getString("id_avion"));
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
public void consultar_vuelo(JComboBox jboxVuelos){
        Connection conexion = null;
        String sentencia_buscar_vuelo = ("SELECT id_vuelo FROM vuelos where estado = 'Libre' ORDER BY id_vuelo");
        
        try {
            
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_vuelo);
            ResultSet result =  sentencia_preparada.executeQuery();
            jboxVuelos.addItem("Seleccione Vuelo");
            
            while(result.next()){
                jboxVuelos.addItem(result.getString("id_vuelo"));
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
public void consultar_cliente(JComboBox cbxCliente){
        Connection conexion = null;
        String sentencia_buscar_cliente = ("SELECT nombre FROM clientes ORDER BY cedula");
        
        try {
            
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_cliente);
            ResultSet result =  sentencia_preparada.executeQuery();
            cbxCliente.addItem("Seleccione un Cliente");
            
            while(result.next()){
                cbxCliente.addItem(result.getString("nombre"));
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
    
public double result;
    
    public void valort(double n1, double n2){
        result = n1 * n2;
    }
}
