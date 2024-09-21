package Ejercicio1.example.application.service;

import Ejercicio1.example.domain.Paciente;
import Ejercicio1.example.infrastructure.repository.PacienteRepository;

import java.util.List;

public class PacienteServiceImpl implements PacienteService {
    private PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void registrarPaciente(Paciente paciente) {
        if(paciente == null || paciente.getNombre() == null || paciente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El paciente o su nombre no pueden ser nulos o vacios");
        }

        // Verifica si el paciente existe en el repositorio
        Paciente pacienteExistente = pacienteRepository.buscarPacientePorNombre(paciente.getNombre());
        if(pacienteExistente != null ) {
            throw new IllegalArgumentException("Ya existe un paciente con este nombre");
        }

        pacienteRepository.guardarPaciente(paciente);
    }

    @Override
    public Paciente buscarPaciente(String nombre) {
        if(nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }
        return pacienteRepository.buscarPacientePorNombre(nombre);
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        if(paciente == null || paciente.getNombre() == null || paciente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El paciente o su nombre no pueden ser nulos o vacios");
        }
        pacienteRepository.actualizarPaciente(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.obtenerTodosLosPacientes();
    }
}
