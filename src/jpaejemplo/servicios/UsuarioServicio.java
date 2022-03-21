

package jpaejemplo.servicios;

import java.util.List;
import jpaejemplo.entidades.Usuario;
import jpaejemplo.persistencia.UsuarioDAO;


public class UsuarioServicio {

    //USO UN ATRIBUTO UsuarioDAO PORQUE LO EMPLEO EN TODOS MIS MÉTODOS
    private UsuarioDAO usuarioDAO;

    // SI O SI DEBO INICIALIZARLO EN MI CONSTRUCTOR VACÍO
    public UsuarioServicio() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    // METODO PARA VALIDAR LOS DATOS PEDIDOS Y SETEAR UN OBJETO USUARIO
    public void crearUsuario(String email, String nombre, String apellido, Integer edad) throws Exception {
        
        try {
            // VALIDACIONES
            if (email == null | email.trim().isEmpty()) {
                throw new Exception("CORREO NO VÁLIDO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new Exception("NOMBRE NO VÁLIDO");
            }

            if (apellido == null | apellido.trim().isEmpty()) {
                throw new Exception("DEBE INGRESAR UN APELLIDO");
            }

            if (Integer.toString(edad) == null | edad < 18 | Integer.toString(edad).trim().isEmpty()) {
                throw new Exception("DEBE SER MAYOR DE EDAD");
            }

            // CREO UNA INSTANCIA DE USUARIO
            Usuario usuario = new Usuario();

            // SETEO LOS VALORES
            usuario.setEmail(email);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEdad(edad);
            
            
            usuarioDAO.guardarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
    }
    
    // METODO QUE VALIDA MAIL Y LO PASA POR PARÁMETRO AL MÉTODO
    // BUSCAR POR EMAIL QUE EJECUTARA UNA QUERY JPQL CON ESE DATO(email)
    public Usuario buscarUsuarioPorEmail(String email) throws Exception{
        // VALIDACIONES
        if(email == null || email.trim().isEmpty()){
            throw new Exception("EMAIL NO VÁLIDO");
        }
        
        // retorna el resultado de la query que encontramos en el 
        // método de usuarioDAO
        return usuarioDAO.buscarUsuarioPorEmail(email);
    }
    
    // METODO QUE VALIDA DOS DATOS NUMÉRICOS
    // Y PUEDE RETORNAR MÁS DE UN REGISTRO
    public List<Usuario> buscarUsuarioPorRangoDeEdad(int edad1, int edad2) throws Exception{
        // VALIDACIONES NUMÉRICAS
        if(Integer.toString(edad1) == null || Integer.toString(edad1).trim().isEmpty()){
            throw new Exception("EDAD NO VÁLIDA");
        }
        
        if(Integer.toString(edad2) == null || Integer.toString(edad2).trim().isEmpty()){
            throw new Exception("EDAD NO VÁLIDA");
        }
        
        return usuarioDAO.buscarUsuarioPorRangoEdad(edad1, edad2);
    }
}
