package com.proyecto.demo1.Repository;

import java.sql.Date;


import org.springframework.stereotype.Repository;

import com.proyecto.demo1.dto.DetalleFacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class DetalleFacturaRepository {

    @PersistenceContext
    private EntityManager entityManager; //ejecutar consultas

    public DetalleFacturaDTO obtenerDetalleFacturaPorCodigo(String facCod) {
        try {
            //llamado del procedimiento
            Object[] resultado = (Object[]) entityManager
                .createNativeQuery("CALL detalle_factura_por_codigo(:facCod)")
                .setParameter("facCod", facCod)
                .getSingleResult();

            if (resultado == null) return null;

            //asignar valores desde el procedimiento al DTO
            DetalleFacturaDTO dto = new DetalleFacturaDTO();
            dto.setCodFactura((String) resultado[0]);
            dto.setNombreCliente((String) resultado[1]);
            dto.setApellidoCliente((String) resultado[2]);
            dto.setTituloPelicula((String) resultado[3]);
            Date date = (Date) resultado[4];
            dto.setFechaFactura(date.toLocalDate());
            dto.setCantidadAsientos((Integer) resultado[5]);
            dto.setSubtotal(((Number) resultado[6]).doubleValue());

            return dto;

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el detalle de la factura", e);
        }
    }
}

