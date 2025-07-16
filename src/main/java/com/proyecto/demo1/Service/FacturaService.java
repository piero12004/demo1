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

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Factura crearFacturaYRetornar(String ucod) {
        Usuario usuario = usuarioRepository.findByUcod(ucod);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Factura factura = new Factura();
        factura.setUsuario(usuario);
        factura.setFecha(LocalDate.now());

        String ultimoCodigo = facturaRepository.UltimoCodigo();
        int num = 1;
        if (ultimoCodigo != null && ultimoCodigo.startsWith("F")) {
            num = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
        }
        String nuevoCodigo = "F" + String.format("%04d", num);
        factura.setFacCod(nuevoCodigo);

        return facturaRepository.save(factura);
    }

    public List<FacturaDTO> obtenerFacturasConUsuario() {
        return facturaRepository.listarFacturasConUsuario();
    }

    public List<Factura> obtenerFacturasPorUsuario(String ucod) {
        return facturaRepository.findByUsuario_Ucod(ucod);
    }
}

