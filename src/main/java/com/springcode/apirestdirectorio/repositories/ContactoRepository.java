package com.springcode.apirestdirectorio.repositories;

import com.springcode.apirestdirectorio.dao.ContactoDTO;
import com.springcode.apirestdirectorio.entities.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto,Long> {

    ContactoDTO findByEmail(String email);
}
