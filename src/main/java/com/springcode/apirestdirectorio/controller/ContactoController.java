package com.springcode.apirestdirectorio.controller;

import com.springcode.apirestdirectorio.dao.ContactoDTO;
import com.springcode.apirestdirectorio.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @PostMapping("/")
    private ResponseEntity<?> saveContacto(@RequestBody ContactoDTO contactoDTO){
        return ResponseEntity.ok(contactoService.saveContacto(contactoDTO));
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateContacto(@PathVariable("id") Long contactoId,@RequestBody ContactoDTO contactoDTO){
      return contactoService.findContactoId(contactoId)
                .map(contactoGuardado -> {
                    contactoGuardado.setId(contactoDTO.getId());
                    contactoGuardado.setNombre(contactoDTO.getNombre());
                    contactoGuardado.setEdad(contactoDTO.getEdad());
                    contactoGuardado.setCelular(contactoDTO.getCelular());
                    contactoGuardado.setFechaRegistro(contactoDTO.getFechaRegistro());

                    contactoService.updateContacto(contactoGuardado);

                    return new ResponseEntity<>(contactoGuardado,HttpStatus.OK);
                })
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    private ResponseEntity<?> listContactos(){
        return ResponseEntity.ok(contactoService.listContacto());
    }

    @GetMapping("/{id}")
    private Optional<ContactoDTO> findContactoForId(@PathVariable("id") Long id){
        return contactoService.findContactoId(id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteContacto(@PathVariable("id") Long id){
        contactoService.deleteContacto(id);
        return new ResponseEntity<>("Contacto eliminado exitosamente"+id,HttpStatus.OK);

    }
}
