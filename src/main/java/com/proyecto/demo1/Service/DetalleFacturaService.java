package com.proyecto.demo1.Service;

import org.springframework.stereotype.Service;

import com.proyecto.demo1.Repository.DetalleFacturaRepository;
import com.proyecto.demo1.dto.DetalleFacturaDTO;

@Service
public class DetalleFacturaService {

    private final DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaService(DetalleFacturaRepository detalleFacturaRepository) {
        this.detalleFacturaRepository = detalleFacturaRepository;
    }

    public DetalleFacturaDTO obtenerDetalle(String facCod) {
        return detalleFacturaRepository.obtenerDetalleFacturaPorCodigo(facCod);
    }
}

