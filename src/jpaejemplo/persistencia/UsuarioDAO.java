package jpaejemplo.persistencia;

import java.util.List;
import jpaejemplo.entidades.Usuario;

// ES UNA HIJA DE DAO POR ESO USAMOS LA PALABRA RESERVADA extends
// SUPER IMPORTANTE QUE ACLAREMOS LA GENERALIZACIÓN ENTRE <> 
// CON LA CLASE ENTIDAD QUE SE MANEJA EN LA CLASE
// TENDREMOS UNA HIJA DAO POR CADA ENTIDAD
public class UsuarioDAO extends DAO<Usuario> {

    // PERSISTENCIA DE UN REGISTRO EN LA DB
    public void guardarUsuario(Usuario usuario) {
        super.guardar(usuario);
    }

    // BUSQUEDA DE UN ELEMENTO POR SU LLAVE PRIMARIA
    public Usuario buscarUsuarioPorEmail(String email) {
        
        Usuario usuario = em.find(Usuario.class, email);
        
        return usuario;
    }

    // BUSQUEDA DE MUCHOS ELEMENTOS CON QUERY JPQL
    public List<Usuario> buscarUsuarioPorRangoEdad(int edadMenor, int edadMayor) {

        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u WHERE u.edad BETWEEN :edad1 AND :edad2")
                .setParameter("edad1", edadMenor).setParameter("edad2", edadMayor).getResultList();

        return usuarios;
    }
}
