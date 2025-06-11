package com.proyecto.demo1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.demo1.Model.Factura;
import com.proyecto.demo1.dto.FacturaDTO;

public interface FacturaRepository extends JpaRepository<Factura,String>{
    
    //consulta uniendo Factura con Usuario
    @Query("SELECT new com.proyecto.demo1.dto.FacturaDTO(f.facCod, u.nombre, f.fecha) FROM Factura f JOIN f.usuario u")
    List<FacturaDTO> listarFacturasConUsuario();
    
    //facturas de un solo usuario
    List<Factura> findByUsuario_Ucod(String ucod);
    
}
