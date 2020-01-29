package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuariRepository extends CrudRepository<Usuari, Long> {

    Usuari findByLoginAndPassword(String login, String password);

    Usuari findById(long id);

}
