package Ejercicio1.example.infrastructure.repository;

import Ejercicio1.example.domain.Paciente;

import java.util.List;

public interface PacienteRepository {
    void guardarPaciente(Paciente paciente);
    Paciente buscarPacientePorNombre(String nombre);
    void actualizarPaciente(Paciente paciente);
    List<Paciente> obtenerTodosLosPacientes();
}
