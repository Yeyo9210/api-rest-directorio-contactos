package com.springcode.apirestdirectorio.mapper;

import com.springcode.apirestdirectorio.dao.ContactoDTO;
import com.springcode.apirestdirectorio.entities.Contacto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactoMapper {

   ContactoMapper INSTANCE = Mappers.getMapper(ContactoMapper.class);

    Contacto toEntity(ContactoDTO contactoDTO);

    ContactoDTO toDto(Contacto contacto);

    public static ContactoDTO mapContactoDTO(Contacto contacto){
        ContactoDTO contactoDTO = new ContactoDTO();
        contactoDTO.setId(contacto.getId());
        contactoDTO.setNombre(contacto.getNombre());
        contactoDTO.setEdad(contacto.getEdad());
        contactoDTO.setCelular(contacto.getCelular());
        contactoDTO.setEmail(contacto.getEmail());
        contactoDTO.setFechaRegistro(contacto.getFechaRegistro());
        return contactoDTO;
    }
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(ContactoDTO contactoDTO, @MappingTarget Contacto contacto);
}
