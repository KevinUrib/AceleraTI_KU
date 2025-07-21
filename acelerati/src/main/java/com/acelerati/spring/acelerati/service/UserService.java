package com.acelerati.spring.acelerati.service;
/*
 * Clase destinada a implementar la logica del CRUD para los usuarios.
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.acelerati.spring.acelerati.entity.User;

@Service
public class UserService {

    private final Map<Long, User> usuarios = new HashMap<>();
    private final AtomicLong idGeneerator = new AtomicLong(); // Generador de ID para los usuarios

    // Guardar un usuario en memoria
    public User crearUsuario(User user) {
        Long id = idGeneerator.incrementAndGet(); // Incrementa el ID y lo obtiene
        user.setId(id); // Asigna el ID al usuario
        usuarios.put(id, user); // Guarda el usuario en el mapa
        return user; // Retorna el usuario creado
    }

    // Metodo para retornar el listado de usuarios mostrando solo sus emails y nombres
    public List<User> listarPorMail() {
        List<User> listaUsuarios = new ArrayList<>(usuarios.values());
        // Retorna una lista de usuarios con solo los campos requeridos
        return listaUsuarios.stream()
                .map(user -> new User(null, user.getNombre(), null, user.getEmail(), null, null))
                .toList();

    }

    // Metodo para retornar detalle de un usuario mostrando todos sus datos
    public User obtenerDetalleUsuario(Long id) {
        return usuarios.get(id);
    }

    // Metodo para editar un usuario dado su email
    public User editarUsuarioPorEmail(String email, User user) {
        for (Map.Entry<Long, User> entry : usuarios.entrySet()) {
            if (entry.getValue().getEmail().equals(email)) {
                user.setId(entry.getKey());
                usuarios.put(entry.getKey(), user);
                return user;
            }
        }
        return null;
    }

    // Metodo para eliminar un usuario dado su email
    public boolean eliminarUsuarioPorEmail(String email) {
        for (Map.Entry<Long, User> entry : usuarios.entrySet()) {
            if (entry.getValue().getEmail().equals(email)) {
                usuarios.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }

}
