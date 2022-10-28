package com.springcode.apirestdirectorio.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "contacto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false)
    @NotEmpty(message = "Nombre del contacto requerido")
    private String nombre;

    @NotNull(message = "Campo edad es requerido")
    @Column(name = "edad",nullable = false)
    private int edad;

    @Column(name = "email",nullable = false)
    @Email(message = "Email es requerido")
    private String email;

    @NotEmpty(message = "Número celular requerido")
    @Column(name = "celular",nullable = false)
    private String celular;

    @JsonFormat(pattern = "YYYY-MM-dd")
    @Column(name = "fechaRegistro",nullable = false)
    private Date fechaRegistro;
}
