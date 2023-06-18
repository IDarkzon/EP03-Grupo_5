package com.dae.ep3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "tbl_cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @Column(name = "id", columnDefinition = "int", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;
    @Column(name = "apellidos", length = 150, nullable = false)
    private String apellidos;
    @Column(name = "correo", length = 100, nullable = false)
    private String correo;
    @Column(name = "celular", columnDefinition = "char(9)", nullable = false)
    private String celular;
    @Column(name = "fecha_creacion", columnDefinition = "datetime")
    private Date fecha_creacion;
    @Column(name = "fecha_modificacion", columnDefinition = "datetime")
    private Date fecha_modificacion;
}
