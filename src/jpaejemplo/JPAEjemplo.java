/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaejemplo;

import java.util.List;
import java.util.Scanner;
import jpaejemplo.entidades.Usuario;
import jpaejemplo.servicios.UsuarioServicio;

/**
 *
 * @author Pili
 */
public class JPAEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Llamados a métodos sstaticos que 
        // están definidos en la misma clase        
        crearUsuario();
        System.out.println(buscarUsuarioPorEmail());
        System.out.println(buscarUsuariosPorRangoDeEdad());

    }

    // METODO DE LECTURA DE DATOS PARA CREAR UN USUARIO
    public static void crearUsuario() throws Exception {

        try {
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");

            System.out.println("Ingrese su dirección de correo electrónico:");
            String email = scanner.next();

            System.out.println("Ingrese su nombre:");
            String nombre = scanner.next();

            System.out.println("Ingrese su apellido:");
            String apellido = scanner.next();

            System.out.println("Ingrese su edad:");
            Integer edad = scanner.nextInt();

            UsuarioServicio usuarioServicio = new UsuarioServicio();
            usuarioServicio.crearUsuario(email, nombre, apellido, edad);
        } catch (Exception e) {
            throw new Exception("malio sal");
        }
    }

    // METODO DE LECTURA DE DATOS PARA INGRESAR UN EMAIL
    public static Usuario buscarUsuarioPorEmail() throws Exception {
        try {
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");

            System.out.println("Ingrese la dirección de correo electrónico del usuario que desea buscar:");
            String email = scanner.next();

            UsuarioServicio usuarioServicio = new UsuarioServicio();
            return usuarioServicio.buscarUsuarioPorEmail(email);
        } catch (Exception e) {
            throw new Exception("error");
        }
    }
    
    // MÉTODO LECTURA DE DATOS
    public static List<Usuario> buscarUsuariosPorRangoDeEdad() throws Exception {
        try {
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");

            System.out.println("Ingrese la edad menor que puede tener el usuario que desea buscar:");
            int edadMenor = scanner.nextInt();
            
            System.out.println("Ingrese la edad mayor que puede tener el usuario que desea buscar:");
            int edadMayor = scanner.nextInt();

            UsuarioServicio usuarioServicio = new UsuarioServicio();
            return usuarioServicio.buscarUsuarioPorRangoDeEdad(edadMenor, edadMayor);
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("ERROR");
        }
    }
}
