package com.example.demo.Service;

import com.example.demo.Model.Usuario;
import java.util.List;

public interface UsuarioService {

    // metodo para autenticar usuario
    Usuario autenticar(String username, String password);

    // metodo para listar todos los usuarios
    List<Usuario> listar();

    // metodo para guardar nuevo usuario
    Usuario guardar(Usuario usuario);

    // metodo para obtener usuario por ID
    Usuario obtenerPorId(Long id);

    // metodo para actualizar usuario
    Usuario actualizar(Long id, Usuario usuario);

    // metodo para eliminar usuario
    void eliminar(Long id);
}
