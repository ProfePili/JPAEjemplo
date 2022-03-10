/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaejemplo;

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
        crearUsuario();
        System.out.println(buscarUsuario());

    }

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

    public static Usuario buscarUsuario() throws Exception {
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
}
