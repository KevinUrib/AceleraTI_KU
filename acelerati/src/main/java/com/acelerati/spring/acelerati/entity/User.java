package com.acelerati.spring.acelerati.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * User clase nos ayuda a definir el modelo de datos de un usuario que vamos a manejar
 * Se aplicaran validaciones en los atributos de la clase
 */
public class User {

    private Long id;

    @NotBlank(message="El nombre es obligatorio")
    private String nombre;

    @NotBlank(message="El apellido es obligatorio")
    private String apellido;

    @NotBlank(message="El email es obligatorio")
    @Email(message="El correo debe ser un email valido")
    private String email;   

    @NotNull(message="La edad es obligatoria")
    @Min(value=1, message="La edad debe ser mayor a 0")
    private Integer edad;

    @NotBlank(message="La ocupacion es obligatoria")
    private String ocupacion;

    // Constructor vacio
    public User() {
    }

    // Constructor con parametros
    public User(Long id, String nombre, String apellido, String email, Integer edad, String ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.ocupacion = ocupacion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

 
    
}
