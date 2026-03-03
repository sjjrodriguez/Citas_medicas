package com.example.demo.Service;

import com.example.demo.Model.Doctor;
import com.example.demo.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceIMP implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceIMP(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> listar() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor guardar(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor obtenerPorId(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor actualizar(Long id, Doctor doctor) {
        if (!doctorRepository.existsById(id)) {
            return null;
        }
        doctor.setIdDoctor(id);
        return doctorRepository.save(doctor);
    }

    @Override
    public void eliminar(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> listarPorEspecialidad(String especialidad) {
        return doctorRepository.findByEspecialidad(especialidad);
    }
}
