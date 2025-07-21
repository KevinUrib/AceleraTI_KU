package com.acelerati.spring.acelerati.controller;
/*
 * Clase destinada a manejar las peticiones HTTP relacionadas con los usuarios.
 * Esta clase es nuestro Controlador REST
 */

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acelerati.spring.acelerati.entity.User;
import com.acelerati.spring.acelerati.service.UserService;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    private final UserService userService;

    // Inyeccion del servicio UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /api/usuarios
    @PostMapping
    public ResponseEntity<User> crearUsuario(@RequestBody User user) {
        User nuevoUsuario = userService.crearUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    // GET /api/usuarios
    // Mostrando el listado de usuarios solo sus emails y nombres
    @GetMapping
    public ResponseEntity<List<User>> listadoDelimitado() {
        List<User> usuarios = userService.listarPorMail();
        return ResponseEntity.ok(usuarios);
    }

    // GET /api/usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerUsuarioDetalle(@PathVariable Long id){
        User user = userService.obtenerDetalleUsuario(id);
        if(user != null){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /api/usuarios/{email}
    @PutMapping("/{email}")
    public ResponseEntity<User> actualizarUsuario(@PathVariable String email, @RequestBody User user){
        User userUpdated = userService.editarUsuarioPorEmail(email, user);
        if(userUpdated != null) {
            return ResponseEntity.ok(userUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/usuarios/{email}
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String email){
        if(userService.eliminarUsuarioPorEmail(email)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
