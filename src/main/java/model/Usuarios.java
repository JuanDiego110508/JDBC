package model;

public class Usuarios {
    private Long id;
    private String nombre;
    private Long edad;

    /*Constructor para crear un usuario*/ 
    public Usuarios(String nombre, Long edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    /*Constructor para traer un usuario*/ 
    public Usuarios(Long id, String nombre, Long edad){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Long getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Usuarios (Id = " + id + ", Nombre = " + nombre + ", Edad = " + edad + ")";
    }
}