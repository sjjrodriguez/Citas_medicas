package com.example.demo.Repository;

import com.example.demo.Model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {

    // Metodo para Buscar comprobante por su codigo de verificacion
    Optional<Comprobante> findByCodigoVerificable(String codigoVerificable);

    // Metodo para Buscar comprobante por ID de cita
    Optional<Comprobante> findByCitaIdCita(Long idCita);

}
