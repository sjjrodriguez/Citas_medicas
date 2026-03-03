package com.example.demo.Service;

import com.example.demo.Model.Comprobante;

public interface ComprobanteService {

    // metodo para buscar comprobante por codigo verificable
    Comprobante buscarPorCodigo(String codigoVerificable);

    // metodo para buscar comprobante por ID de cita
    Comprobante buscarPorCita(Long idCita);

    // metodo para obtener comprobante por ID
    Comprobante obtenerPorId(Long idComprobante);
}
