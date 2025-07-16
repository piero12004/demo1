package com.proyecto.demo1.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.proyecto.demo1.Model.DetalleFactura;



public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, String> {

    @Query(value = "CALL detalle_factura_por_codigo(:facCod)", nativeQuery = true)
    List<Object[]> obtenerDetalleFacturaPorCodigo(@Param("facCod") String facCod);
 
    @Query(value = "SELECT cod_detalle FROM detalle_factura ORDER BY cod_detalle DESC LIMIT 1", nativeQuery = true)
    String obtenerUltimoCodigoDetalle();

}
