package com.springcode.apirestdirectorio.services.impl;

import com.springcode.apirestdirectorio.dao.ContactoDTO;
import com.springcode.apirestdirectorio.entities.Contacto;
import com.springcode.apirestdirectorio.exceptions.ResourceNotFoundException;
import com.springcode.apirestdirectorio.mapper.ContactoMapper;
import com.springcode.apirestdirectorio.repositories.ContactoRepository;
import com.springcode.apirestdirectorio.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private ContactoMapper contactoMapper;

    @Override
    public ContactoDTO saveContacto(ContactoDTO contactoDTO) {
        Contacto contacto = contactoMapper.toEntity(contactoDTO);
        Optional<ContactoDTO> contactoGuardado = Optional.ofNullable
                (contactoRepository.findByEmail(contactoDTO.getEmail()));
        if (contactoGuardado.isPresent()) {
            throw new ResourceNotFoundException("El empleado con ese email ya existe :"+contactoDTO.getEmail());
        }
        return contactoMapper.toDto(contactoRepository.save(contacto));
    }

    @Override
    public List<ContactoDTO> listContacto() {
        return contactoRepository.findAll()
                .stream()
                .map(ContactoMapper::mapContactoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactoDTO updateContacto(ContactoDTO contactoDTO) {
        Contacto contacto = contactoMapper.toEntity(contactoDTO);
        return contactoMapper.toDto(contactoRepository.save(contacto));
    }

    @Override
    public Optional<ContactoDTO> findContactoId(Long id) {
        return Optional.ofNullable(contactoMapper.toDto(contactoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id de contacto no encontrado")
        )));
    }

    @Override
    public void deleteContacto(Long id) {
        contactoMapper.toDto(contactoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Id de contacto no encontrado")
        ));
        contactoRepository.deleteById(id);
    }
}
