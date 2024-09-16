package org.example;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

@Data
@Builder
public class Promocion {
    private Long id;
    private String denominacion, descripcionDescuento;
    private LocalDate fechaDesde, fechaHasta;
    private LocalTime horaDesde, horaHasta;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    private HashSet<Articulo> promociones = new HashSet<>();
    private HashSet<Imagen> promoImagen = new HashSet<>();

}
