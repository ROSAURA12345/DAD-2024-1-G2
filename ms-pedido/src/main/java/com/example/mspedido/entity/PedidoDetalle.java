package com.example.mspedido.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre_producto;
    private Integer  cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal; // Subtotal del detalle (precioUnitario * cantidad)

    private String descripcion;

    @ManyToOne
    private Pedido pedido;


}
