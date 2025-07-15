package com.proyecto.demo1.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo1.Model.DetalleFactura;
import com.proyecto.demo1.Model.Factura;
import com.proyecto.demo1.Model.Pelicula;
import com.proyecto.demo1.Repository.DetalleFacturaRepository;
import com.proyecto.demo1.Repository.PeliculaRepository;
import com.proyecto.demo1.dto.DetalleFacturaDTO;

import jakarta.transaction.Transactional;

@Service
public class DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Transactional
    public void guardarDetalleFactura(Factura factura, String peliCod, int asientos, LocalDate fecha, String horario) {
        System.out.println("Insertando detalle factura con datos:");
        System.out.println("Factura: " + factura.getFacCod());
        System.out.println("Película: " + peliCod);
        System.out.println("Asientos: " + asientos);
        System.out.println("Fecha función: " + fecha);
        System.out.println("Horario: " + horario);

        Pelicula pelicula = peliculaRepository.findById(peliCod)
                .orElseThrow(() -> new RuntimeException("Película no encontrada"));

        DetalleFactura detalle = new DetalleFactura();
        detalle.setCodDetalle(generarCodigoDetalle());
        detalle.setFactura(factura);
        detalle.setPelicula(pelicula);
        detalle.setAsientos(asientos);
        detalle.setFechaFuncion(fecha);
        detalle.setHorarioFuncion(horario);

        // Verifica que no se repita
        if (detalleFacturaRepository.existsById(detalle.getCodDetalle())) {
            throw new IllegalStateException("Código de detalle ya existe");
        }
        detalleFacturaRepository.saveAndFlush(detalle);
    }


    public DetalleFacturaDTO obtenerDetalle(String facCod) {
        List<Object[]> resultados = detalleFacturaRepository.obtenerDetalleFacturaPorCodigo(facCod);
        if (resultados == null || resultados.isEmpty()) return null;

        Object[] resultado = resultados.get(0); // Primera fila del resultado


        DetalleFacturaDTO dto = new DetalleFacturaDTO();
        dto.setCodFactura((String) resultado[0]);
        dto.setNombreCliente((String) resultado[1]);
        dto.setApellidoCliente((String) resultado[2]);
        dto.setTituloPelicula((String) resultado[3]);

        dto.setFechaFactura(((Date) resultado[4]).toLocalDate());
        dto.setCantidadAsientos(((Number) resultado[5]).intValue());
        dto.setSubtotal(((Number) resultado[6]).doubleValue());
        dto.setFechaFuncion(((Date) resultado[7]).toLocalDate());
        dto.setHorarioFuncion((String) resultado[8]);

        return dto;
    }

    private String generarCodigoDetalle() {
        String ultimoCodigo = detalleFacturaRepository.obtenerUltimoCodigoDetalle();
        int nuevoNumero = 1;

        if (ultimoCodigo != null && ultimoCodigo.startsWith("D")) {
            try {
                nuevoNumero = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
            } catch (NumberFormatException e) {
                nuevoNumero = 1;
            }
        }

        return String.format("D%04d", nuevoNumero); // D0001, D0002, etc.
    }

}
