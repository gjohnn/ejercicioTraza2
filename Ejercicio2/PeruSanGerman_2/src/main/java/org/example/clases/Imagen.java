package org.example.clases;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Imagen {

    private Long id;
    private String denominacion;

}
