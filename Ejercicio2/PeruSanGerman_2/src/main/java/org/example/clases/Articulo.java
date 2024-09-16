package org.example.clases;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Articulo {

    private Long id;
    private String denominacion;
    private Double precioVenta, precioCompra;
    private Integer stockActual, stockMaximo;
    private Imagen imagen;
    private UnidadMedida unidadMedida;
}
