

package jpaejemplo.persistencia;

import jpaejemplo.entidades.Usuario;


public class UsuarioDAO extends DAO<Usuario>{
    
    public void guardarUsuario(Usuario usuario){
        super.guardar(usuario);
    }
    
    public Usuario buscarUsuarioPorEmail(String email){
        conectar();
        Usuario usuario = em.find(Usuario.class, email);
        desconectar();
        return usuario;
    }
    
    public Usuario buscarUsuarioPorRangoEdad(int edadMenor, int edadMayor){
        conectar();
        Usuario usuario = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.edad BETWEEN :edad1 AND :edad2").setParameter("edad1", edadMenor).setParameter("edadMayor", edadMayor);
        desconectar();
        return usuario;
    }
}
