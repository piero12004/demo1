package com.proyecto.demo1.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo1.Model.Factura;
import com.proyecto.demo1.Model.Usuario;
import com.proyecto.demo1.Repository.FacturaRepository;
import com.proyecto.demo1.Repository.UsuarioRepository;
import com.proyecto.demo1.dto.FacturaDTO;
import com.proyecto.demo1.dto.GenerarFacturaDTO;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    //generar facturas
    public void crearFactura(String fac_cod,String ucod, LocalDate fecha){
        Usuario usuario = usuarioRepository.findByUcod(ucod);
    if (usuario == null) {
        throw new RuntimeException("Usuario no encontrado");
    }

    GenerarFacturaDTO dto = new GenerarFacturaDTO(fac_cod, usuario, fecha);
    Factura Nfactura = dto.getFactura();

    //generar nuevo codigo (F00x)
    if (Nfactura.getFacCod() == null || Nfactura.getFacCod().isEmpty()) {
        String ultimoCodigo = facturaRepository.UltimoCodigo();
        int num = 1;
        if (ultimoCodigo != null && ultimoCodigo.startsWith("F")) {
            num = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
        }
        String nuevoCodigo = "F" + String.format("%04d", num);
        Nfactura.setFacCod(nuevoCodigo);
    }

    facturaRepository.save(Nfactura);
    }

    //facturas con datos del usuario
    public List<FacturaDTO> obtenerFacturasConUsuario(){
        return facturaRepository.listarFacturasConUsuario();
    }

    //facturas de un usuario en especifico
    public List<Factura> obteneFacturasPorUsuario(String ucod){
        return facturaRepository.findByUsuario_Ucod(ucod);
    }
}
