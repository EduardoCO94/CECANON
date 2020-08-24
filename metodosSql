package modelo;

/**
 *
 * @author eduar
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class metodosSql extends Conexion {

    Connection coneccion = getConexion();
    Calendar cal = Calendar.getInstance();
    PreparedStatement ps = null;
    ResultSet result = null;
    String sql;
    DefaultTableModel modelo = new DefaultTableModel();
    Usuarios p = new Usuarios();

    //-------- Metodos Usuarios -----------------------
    public boolean Modificar(Usuarios usr) {
        sql = "UPDATE usuario SET  nombre=?, correo=?, usuario=? , rol=? WHERE idusuario = ? ";
        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getCorreo());
            ps.setString(3, usr.getUsuario());
            ps.setInt(4, usr.getRol());
            ps.setInt(5, usr.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    //-------- Metodo Eliminar ---------------------
    public int Eliminar(int id) {
        sql = "delete from usuario where idusuario =" + id;
        int r = 0;
        try {

            ps = coneccion.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

   
    public boolean Comboboxus(JComboBox combobox){  
        sql = "SELECT * FROM rol " ;
        
        try{
                        
            ps = coneccion.prepareStatement(sql);
            result = ps.executeQuery();
            
            while (result.next()) {
                combobox.addItem(result.getString("rol"));
                
            }
            
            result.close();
           
        }catch(SQLException e){
            
        }
        return false;
        
        
    }
//-------- Metodo Guardar -----------------------
    public boolean guardar(Usuarios usr) {

        sql = "INSERT INTO inventario (codigo,nombre,precio,raza) VALUES (?,?,?,?)";
        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, usr.getCodigo());
            ps.setString(2, usr.getNombre());
            ps.setInt(3, usr.getPrecio());
            ps.setString(4, usr.getRaza());
            ps.execute();
            return true;
        } catch (SQLException e) {
            //Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
    
    
    
    //---------------- tabla buscar --------------
     public boolean Buscar(Usuarios usr) {
        sql = "SELECT * FROM usuario WHERE nombre= ? ";
        try {

           
            ps = coneccion.prepareStatement(sql);
            result = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) result.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();


            modelo.addColumn("ID");
            modelo.addColumn("Nombres");
            modelo.addColumn("Correo");
            modelo.addColumn("Usuario");
            modelo.addColumn("Rol");

            while (result.next()) {

                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = result.getObject(i + 1);

                }

                modelo.addRow(filas);
            }
            result.close();
            return false;
        } catch (SQLException e) {
            Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
     // Cargara tablea usuarios 
    public void tablaUsuarios(JTable Jtable) {
        sql = "SELECT u.idusuario, u.nombre, u.correo,u.usuario, r.rol "
                + "FROM usuario u INNER JOIN rol r ON u.rol = r.idrol"
                + " ORDER BY u.idusuario ASC";
        try {

            Jtable.setModel(modelo);
            ps = coneccion.prepareStatement(sql);
            result = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) result.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombres");
            modelo.addColumn("Correo");
            modelo.addColumn("Usuario");
            modelo.addColumn("Rol");

            while (result.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = result.getObject(i + 1);

                }

                modelo.addRow(filas);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //-------- Metodo Buscar --------------------------
    //------------- resgistro de usuarios --------- 
    public boolean registrar(Usuarios usr) {
        sql = "INSERT INTO usuario(nombre,correo,usuario,contraseña,rol) VALUES (?,?,?,?,?)";
        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getCorreo());
            ps.setString(3, usr.getUsuario());
            ps.setString(4, usr.getContraseña());
            ps.setInt(5, usr.getRol());
            //ps.setInt(Integer.parseInt(result.getString("")));
            ps.execute();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    //-------- Fin metodos Usuario--------------------------
    
    
    //--------------- Inicio de sesion --------------
    public boolean login(Usuarios usr) {
        sql = "SELECT u.idusuario, u.usuario, u.contraseña, u.nombre, u.rol, t.rol FROM usuario "
                + "AS u INNER JOIN rol AS t ON u.rol=t.idrol WHERE usuario = ?";
        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            result = ps.executeQuery();

            if (result.next()) {
                if (usr.getContraseña().equals(result.getString(3))) {
                    
                    usr.setId(result.getInt(1));
                    usr.setNombre(result.getString(4));
                    usr.setId_tipo(result.getInt(5));
                    usr.setNombre_tipo(result.getString(6));
                    
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException e) {
            Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    //------ fin metodo login--------------------------
    
    
    //----------------- Validaciones--------------------
    // condiciones para correo electronico
    public boolean Correo(String correo) {
        // patron
        Pattern patter = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = patter.matcher(correo);
        return matcher.find();
    }

    // metodos que validan usuario y correo ya esten registrados
    public int existeUsuario(String usuario) {

        sql = "SELECT count(idUs) from usuarios where Usuario = ?";

        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, usuario);
            result = ps.executeQuery();

            if (result.next()) {
                return result.getInt(1);
            }
            return 1;
        } catch (SQLException e) {
            Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
            return 1;
        }
    }

    public int existeCorreo(String correo) {

        sql = "SELECT count(idusuario) from usuario where correo = ?";

        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, correo);
            result = ps.executeQuery();

            if (result.next()) {
                return result.getInt(1);
            }
            return 1;
        } catch (SQLException e) {
            Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
            return 1;
        }
    }

    
    //------------------ metodos productos----------------
    // cargr tablas Productos
    public void tabaProductos(JTable Jtable) {
        sql = "SELECT codproducto, descripcion, proveedor, precio, existencia FROM producto";
        try {

            Jtable.setModel(modelo);
            ps = coneccion.prepareStatement(sql);
            result = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) result.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("CODIGO");
            modelo.addColumn("DESCRIPCION");
            modelo.addColumn("PROVEEDOR");
            modelo.addColumn("PRECIO");
            modelo.addColumn("EXISTENCIA");

            while (result.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = result.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //------------------------ Productos--------------------------------------------
    public void tablaBuscar(JTable Jtable) {

        sql = "SELECT * FROM inventario WHERE codigo=? ";
        try {

            Jtable.setModel(modelo);
            ps = coneccion.prepareStatement(sql);
            result = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) result.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Raza");

            while (result.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = result.getObject(i + 1);
                }

                modelo.addRow(filas);
            }

        } catch (SQLException ex) {

            System.err.println(ex.toString());

        }

    }

   
    //---- eliminar producto---------
    public int EliminarProd(int id) {
        sql = "delete from producto where codproducto=" + id;
        int r = 0;
        try {

            ps = coneccion.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public boolean ModificarProduc(Usuarios usr) {
        sql = "UPDATE producto SET  descripcion=?, proveedor=?, precio=? , existencia=?  WHERE codproducto = ? ";
        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, usr.getDescripcion());
            ps.setInt(2, usr.getProveedor());
            ps.setInt(3, usr.getPrecio());
            ps.setInt(4, usr.getExistencia());
            ps.setInt(5, usr.getCodproducto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public boolean registrarProduct(Usuarios usr) {
        sql = "INSERT INTO producto(descripcion, proveedor, precio, existencia) VALUES (?,?,?,?)";
        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, usr.getDescripcion());
            ps.setInt(2, usr.getProveedor());
            ps.setInt(3, usr.getPrecio());
            ps.setInt(4, usr.getExistencia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(metodosSql.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

}
