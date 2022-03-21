package jpaejemplo.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// DAO PADRE CON GENERALIZACIÓN (<T>)
public class DAO<T> {

    // el EntityManagerFactory nos permitirá crear un EntityManager
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPAEjemploPU");
    // el EM nos permitira realizar transacciones con la DB
    protected EntityManager em = EMF.createEntityManager();

    // CONECTAR A LA BASE DE DATOS
    protected void conectar() {
        //VERIFICO QUE NO EXISTA LA CONEXION
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    // DESCONECTAR DE LA BASE DE DATO
    protected void desconectar() {
        
        // VERIFICO QUE EXISTA LA CONEXION
        // SI LA CONEXION ESTA CERRADA, ¿ QUE CIERRO ?
        if (em.isOpen()) {
            em.close();
        }
    }

    // INSERT INTO - PERSISTIR UN REGISTRO EN LA DB
    protected void guardar(T objeto) {
        conectar(); //conecto a la DB
        em.getTransaction().begin(); // inicio la transaccion
        em.persist(objeto); // persisto/guardo un registro completo
        em.getTransaction().commit(); // finalizo la transaccion
        desconectar(); // me desconecto de mi base de datos
    }

    // UPDATE - MODIFICAR DATOS DE UN REGISTRO
    protected void actualizar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto); // elimina el registro viejo, y lo reemplaza por el nuevo con sus respectivas modificaciones
        em.getTransaction().commit();
        desconectar();
    }

    // DELETE - borrar un registro/fila de mi tabla
    protected void eliminar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }

}
