/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Erick Silva Cesar Cañon
 */
public class Usuarios {
    private int id;
    private String Usuario;
    private String Contraseña;
    private String Correo;
    private int precio;
    private String nombre;
    private int rol;
    private String codigo;
    private String raza;
    private int codproducto;
    private String descripcion;	
    private int proveedor;	
    private int existencia;	
    private String foto;
    private String nombre_tipo;
    private int id_tipo;

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
    
   

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }
    
    
    

    //-- getter y setter Usuarios------
    
    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    //---------------------------------------------
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    //---------------------------------------
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //---------------------------------------
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    //---------------------------------------
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    //---------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //-----------------------------------------
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    //-------------------------------------------
    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    //----------------------------------------------
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    //---------------Fin Usuarios---------------------------

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getCorreo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addColumn(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //---- getter y setter Productos -----
    
    public int getCodproducto() {
        return codproducto;
    }
    
    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }
    //-----------------------------------
    public String getDescripcion() {
        return descripcion;
    }
    
     public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //------------------------------------------

    public int getProveedor() {
        return proveedor;
    }
    
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
    
    //----------------------------------------

    public int getExistencia() {
        return existencia;
    }
    
     public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

     //------------------------------------------
    public String getFoto() {
        return foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    //-------- fin productos----------
 
}
