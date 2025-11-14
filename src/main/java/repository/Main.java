package repository;

import java.util.Scanner;

import model.Usuarios;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuariosRepository usuariosRepository = new UsuariosRepository();

        int opcion = 0;
        do {
            System.out.println("\n MENU DE USUARIOS");
            System.out.println("1. Insertar usuario: ");
            System.out.println("2. Listar usuarios: ");
            System.out.println("3. Buscar usuario por nombre: ");
            System.out.println("4. Actualizar usuario: ");
            System.out.println("5. Eliminar usuario: ");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n INSERTAR USUARIO");
                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la edad del usuario: ");
                    Long edad = scanner.nextLong();

                    Usuarios usuarioNuevo = new Usuarios(nombre, edad);
                    usuariosRepository.insertarUsuario(usuarioNuevo);
                    break;

                case 2:
                    System.out.println("\n LISTAR USUARIOS");
                    List<Usuarios> usuarios = usuariosRepository.listarUsuarios();
                    if (usuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                    } else {
                        for (Usuarios usuario : usuarios) {
                            System.out.println(usuario.toString());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n BUSCAR USUARIO POR NOMBRE");
                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombreBuscar = scanner.nextLine();
                    Usuarios usuarioEncontrado = usuariosRepository.BuscarUsuario(nombreBuscar);

                    if (usuarioEncontrado != null) {
                        System.out.println("Usuario encontrado: " + usuarioEncontrado.toString());
                    } else {
                        System.out.println("No se encontro ningun usuario con ese nombre.");
                    }
                    break;
                
                case 4:
                    System.out.println("\n ACTUALIZAR USUARIO");
                    System.out.println("Ingrese el ID del usuario: ");
                    Long idActualizar = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Nueva edad: ");
                    Long nuevaEdad = scanner.nextLong();

                    usuariosRepository.actualizarUsuario(idActualizar, nuevoNombre, nuevaEdad);
                    break;

                case 5:
                    System.out.println("\n ELIMINAR USUARIO");
                    System.out.println("Ingrese el ID del usuario: ");
                    Long idEliminar = scanner.nextLong();
                    usuariosRepository.eliminarUsuario(idEliminar);
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo. ");
            }
        } while (opcion != 6);
        scanner.close();
    }
}