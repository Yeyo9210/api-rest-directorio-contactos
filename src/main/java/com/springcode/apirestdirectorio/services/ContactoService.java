package com.springcode.apirestdirectorio.services;

import com.springcode.apirestdirectorio.dao.ContactoDTO;

import java.util.List;
import java.util.Optional;

public interface ContactoService {
    ContactoDTO saveContacto(ContactoDTO contactoDTO);
    List<ContactoDTO> listContacto();
    ContactoDTO updateContacto(ContactoDTO contactoDTO);
    Optional<ContactoDTO> findContactoId(Long id);
    void deleteContacto(Long id);
}
