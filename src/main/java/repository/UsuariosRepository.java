package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.Conexion;
import model.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class UsuariosRepository {
    public void insertarUsuario(Usuarios usuario){
        String sql = "INSERT INTO USUARIOS (NOMBRE, EDAD) VALUES(?, ?)";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setLong(2, usuario.getEdad());

            /* Ejecutamos nuestra consulta sql */
            preparedStatement.executeUpdate();

            /* Mensaje Informativo */ 
            System.out.println("Usuario insertado correctamente. ");

            /* Atrapamos cualquier error */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Usuarios> listarUsuarios(){
        String sql = "SELECT * FROM USUARIOS";
        List<Usuarios> usuarios = new ArrayList<>();

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Usuarios usuario = new Usuarios(
                    resultSet.getLong("ID"),
                    resultSet.getString("NOMBRE"),
                    resultSet.getLong("EDAD"));

                    usuarios.add(usuario);
            }
        } catch( Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    // Buscar usuario por nombre
    public Usuarios BuscarUsuario(String nombre){
        String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ?";
        Usuarios usuario = null;

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) 
                usuario = new Usuarios(
                    resultSet.getLong("ID"),
                    resultSet.getString("NOMBRE"),
                    resultSet.getLong("EDAD"));
        } catch( Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuarios actualizarUsuario(Long id, String nombre, Long edad){
        String sql = "UPDATE USUARIOS SET NOMBRE = ?, EDAD = ? WHERE ID = ?";
        Usuarios usuario = null;

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            preparedStatement.setLong(2, edad);
            preparedStatement.setLong(3, id);
            /* Ejecutamos nuestra consulta sql */
            preparedStatement.executeUpdate();
            usuario = new Usuarios(id, nombre, edad);
            /* Mensaje Informativo */
            System.out.println("Usuario actualizado correctamente. ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public void eliminarUsuario(Long id){
        String sql = "DELETE FROM USUARIOS WHERE ID = ?";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            /* Ejecutamos nuestra consulta sql */
            preparedStatement.executeUpdate();

            /* Mensaje Informativo */ 
            System.out.println("Usuario eliminado correctamente. ");

            /* Atrapamos cualquier error */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
