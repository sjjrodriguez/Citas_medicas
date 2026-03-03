package com.example.demo.Service;

import com.example.demo.Model.Comprobante;
import com.example.demo.Repository.ComprobanteRepository;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteServiceIMP implements ComprobanteService {

    private final ComprobanteRepository comprobanteRepository;

    public ComprobanteServiceIMP(ComprobanteRepository comprobanteRepository) {
        this.comprobanteRepository = comprobanteRepository;
    }

    @Override
    public Comprobante buscarPorCodigo(String codigoVerificable) {
        return comprobanteRepository.findByCodigoVerificable(codigoVerificable).orElse(null);
    }

    @Override
    public Comprobante buscarPorCita(Long idCita) {
        return comprobanteRepository.findByCitaIdCita(idCita).orElse(null);
    }

    @Override
    public Comprobante obtenerPorId(Long idComprobante) {
        return comprobanteRepository.findById(idComprobante).orElse(null);
    }
}
