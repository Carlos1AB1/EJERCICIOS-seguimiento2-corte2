package Ejercicio1.example.infrastructure.repository;

import Ejercicio1.example.domain.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepositoryImpl implements PacienteRepository {
    private static final String FILE_PATH = "pacientes.txt";

    @Override
    public void guardarPaciente(Paciente paciente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(paciente.getNombre() + "," + paciente.getApellido() + "," + paciente.getEdad() + "," +
                    paciente.getGenero() + "," + paciente.getDireccion() + "," + paciente.getTelefono());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el paciente: " + e.getMessage(), e);
        }
    }

    @Override
    public Paciente buscarPacientePorNombre(String nombre) {
        return obtenerTodosLosPacientes().stream()
                .filter(paciente -> paciente.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarPaciente(Paciente pacienteActualizado) {
        List<Paciente> pacientes = obtenerTodosLosPacientes();
        boolean actualizado = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Paciente paciente : pacientes) {
                if (paciente.getNombre().equalsIgnoreCase(pacienteActualizado.getNombre())) {
                    writer.write(pacienteActualizado.getNombre() + "," + pacienteActualizado.getApellido() + "," +
                            pacienteActualizado.getEdad() + "," + pacienteActualizado.getGenero() + "," +
                            pacienteActualizado.getDireccion() + "," + pacienteActualizado.getTelefono());
                    actualizado = true;
                } else {
                    writer.write(paciente.getNombre() + "," + paciente.getApellido() + "," + paciente.getEdad() + "," +
                            paciente.getGenero() + "," + paciente.getDireccion() + "," + paciente.getTelefono());
                }
                writer.newLine();
            }

            if (!actualizado) {
                throw new RuntimeException("Paciente no encontrado para actualizar: " + pacienteActualizado.getNombre());
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al actualizar el paciente: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Paciente> obtenerTodosLosPacientes() {
        // Crear el archivo si no existe
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        }

        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                Paciente paciente = new Paciente(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], datos[4], datos[5]);
                pacientes.add(paciente);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer los pacientes: " + e.getMessage(), e);
        }
        return pacientes;
    }
}
