package com.proyecto.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo1.Model.Factura;
import com.proyecto.demo1.Repository.FacturaRepository;
import com.proyecto.demo1.dto.FacturaDTO;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    //facturas con datos del usuario
    public List<FacturaDTO> obtenerFacturasConUsuario(){
        return facturaRepository.listarFacturasConUsuario();
    }

    //facturas de un usuario en especifico
    public List<Factura> obteneFacturasPorUsuario(String ucod){
        return facturaRepository.findByUsuario_Ucod(ucod);
    }
}
