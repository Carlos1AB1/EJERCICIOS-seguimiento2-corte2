package Ejercicio1.example.application.service;

import Ejercicio1.example.domain.Paciente;
import java.util.List;

public interface PacienteService {
    void registrarPaciente(Paciente paciente);
    Paciente buscarPaciente(String nombre);
    void actualizarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();
}
