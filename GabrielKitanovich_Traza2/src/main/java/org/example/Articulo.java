package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta, precioCompra;
    private Integer stockActual, stockMax;
    private UnidadMedida unidadDeMedida;
    private Imagen imagen;
}
