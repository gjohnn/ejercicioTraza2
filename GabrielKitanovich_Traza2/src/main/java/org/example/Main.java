package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    static List<Promocion> promociones;
    static List<Articulo> articulos;

    public static void main(String[] args) {
        //Unidad de medida
        UnidadMedida porciones8 = new UnidadMedida(1L, "8 porciones");
        UnidadMedida porciones4 = new UnidadMedida(2L, "4 porciones");
        UnidadMedida litro = new UnidadMedida(3L, "1 litro");
        //Imagenes
        Imagen imagen1 = new Imagen(1L, "Pizza Grande Hawaiana");
        Imagen imagen2 = new Imagen(2L, "Pizza Grande Napolitana");
        Imagen imagen3 = new Imagen(3L, "Pizza Grande Muzza");
        Imagen imagen4 = new Imagen(4L, "Pizza Chica Hawaiana");
        Imagen imagen5 = new Imagen(5L, "Pizza Chica Napolitana");
        Imagen imagen6 = new Imagen(6L, "Pizza Chica Muzza");
        Imagen imagen7 = new Imagen(7L, "Cerveza Andes");
        Imagen imagen8 = new Imagen(8L, "Cerveza Quilmes");
        Imagen imahappy1 = new Imagen(9L, "happyhour");
        Imagen imahappy2 = new Imagen(10L, "happyhour");
        Imagen verano1 = new Imagen(11L, "verano");
        Imagen verano2 = new Imagen(12L, "verano");
        Imagen invierno1 = new Imagen(13L, "invierno");
        Imagen invierno2 = new Imagen(14L, "invierno");

        // Articulos
        Articulo cerveza1 = new Articulo(1L, "Cerveza Andes", 15.0, 12.0, 10, 15, litro, imagen7);
        Articulo cerveza2 = new Articulo(2L, "Cerveza Quilmes", 30.0, 24.0, 20, 30, litro, imagen8);

        Articulo pizzaGrandeHawaiana = new Articulo(3L, "Pizza Grande Hawaiana", 100.0, 80.0, 30, 50, porciones8, imagen1);
        Articulo pizzaGrandeNapolitana = new Articulo(4L, "Pizza Grande Napolitana", 120.0, 90.0, 25, 45, porciones8, imagen2);
        Articulo pizzaGrandeMuzza = new Articulo(5L, "Pizza Grande Muzza", 110.0, 85.0, 20, 40, porciones8, imagen3);

        Articulo pizzaChicaHawaiana = new Articulo(6L, "Pizza Chica Hawaiana", 60.0, 50.0, 15, 25, porciones4, imagen4);
        Articulo pizzaChicaNapolitana = new Articulo(7L, "Pizza Chica Napolitana", 70.0, 55.0, 12, 20, porciones4, imagen5);
        Articulo pizzaChicaMuzza = new Articulo(8L, "Pizza Chica Muzza", 65.0, 52.0, 18, 30, porciones4, imagen6);

        articulos = Arrays.asList(cerveza1, cerveza2, pizzaGrandeHawaiana, pizzaGrandeNapolitana, pizzaGrandeMuzza, pizzaChicaHawaiana, pizzaChicaNapolitana, pizzaChicaMuzza);

        // Happy Hour Promotion
        Promocion happyHour = Promocion.builder()
                .id(1L)
                .denominacion("Happy Hour")
                .descripcionDescuento("Descuento en pizza y cerveza")
                .fechaDesde(LocalDate.now()) // Example date
                .fechaHasta(LocalDate.now().plusDays(7)) // Example end date
                .horaDesde(LocalTime.of(17, 0)) // Example start time
                .horaHasta(LocalTime.of(20, 0)) // Example end time
                .precioPromocional(65.0) // Example promotional price
                .tipoPromocion(TipoPromocion.HAPPY_HOUR)
                .promociones(new HashSet<>(Arrays.asList(pizzaGrandeHawaiana, pizzaGrandeMuzza, cerveza2)))
                .promoImagen(new HashSet<>(Arrays.asList(imahappy1)))
                .build();

// Verano Promotion
        Promocion verano = Promocion.builder()
                .id(2L)
                .denominacion("Verano")
                .descripcionDescuento("Promo de verano con pizza y cerveza")
                .fechaDesde(LocalDate.now()) // Example date
                .fechaHasta(LocalDate.now().plusDays(14)) // Example end date
                .horaDesde(LocalTime.of(12, 0)) // Example start time
                .horaHasta(LocalTime.of(22, 0)) // Example end time
                .precioPromocional(45.0) // Example promotional price
                .tipoPromocion(TipoPromocion.VERANO)
                .promociones(new HashSet<>(Arrays.asList(pizzaChicaHawaiana, pizzaGrandeNapolitana, cerveza1, cerveza2)))
                .promoImagen(new HashSet<>(Arrays.asList(verano1)))
                .build();

// Invierno Promotion
        Promocion invierno = Promocion.builder()
                .id(3L)
                .denominacion("Invierno")
                .descripcionDescuento("Descuento en pizza y cerveza para invierno")
                .fechaDesde(LocalDate.now()) // Example date
                .fechaHasta(LocalDate.now().plusDays(30)) // Example end date
                .horaDesde(LocalTime.of(18, 0)) // Example start time
                .horaHasta(LocalTime.of(23, 0)) // Example end time
                .precioPromocional(20.0) // Example promotional price
                .tipoPromocion(TipoPromocion.INVIERNO)
                .promociones(new HashSet<>(Arrays.asList(pizzaGrandeHawaiana, pizzaChicaMuzza, cerveza2)))
                .promoImagen(new HashSet<>(Arrays.asList(invierno1)))
                .build();
        promociones = Arrays.asList(happyHour, verano, invierno);

        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("  --------  MENU --------  ");
        System.out.println("1) Promociones");
        System.out.println("2) Articulos");
        System.out.println("3) Mostrar promocion mas economica");
        System.out.println("0) Salir");
        option(scanner.next());
    }

    public static void option(String option) {
        int index = 0;

        switch (option) {
            case "1":
                System.out.println(" ------------- Promociones ------------- ");
                for (Promocion e : promociones) {
                    ++index;
                    System.out.println(index + " | Promocion: " + e.getDenominacion());
                    if (e.getTipoPromocion().equals(TipoPromocion.VERANO)) {
                        System.out.println("Disponible desde: " + e.getFechaDesde() + "| Hasta: " + e.getFechaHasta());
                        System.out.println("Hora: " + e.getHoraDesde() + " - " + e.getHoraHasta());
                    }
                    System.out.println("Precio: " + e.getPrecioPromocional());
                }
                break;
            case "2":
                System.out.println(" ------------- Articulos ------------- ");
                for (Articulo e : articulos) {
                    ++index;
                    System.out.println(index + " | Articulo: " + e.getDenominacion());
                    System.out.println("Precio: " + e.getPrecioVenta());
                }
                break;
            case "3":
                System.out.println("Promocion mas barata");
                Optional<Promocion> promocionMasBarata = promociones.stream()
                        .min((p1, p2) -> Double.compare(p1.getPrecioPromocional(), p2.getPrecioPromocional()));

                promocionMasBarata.ifPresent(p ->
                        System.out.println("La promoción más barata es: " + p.getDenominacion() + " con un precio de " + p.getPrecioPromocional())
                );
                break;
            case "0":
                System.exit(0);
                break;

        }
        menu();
    }
}