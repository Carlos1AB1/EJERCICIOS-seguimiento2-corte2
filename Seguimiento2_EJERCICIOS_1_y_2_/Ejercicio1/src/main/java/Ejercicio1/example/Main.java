package Ejercicio1.example;

import Ejercicio1.example.application.service.PacienteService;
import Ejercicio1.example.application.service.PacienteServiceImpl;
import Ejercicio1.example.domain.Cita;
import Ejercicio1.example.domain.Paciente;
import Ejercicio1.example.infrastructure.repository.PacienteRepositoryImpl;

import javax.swing.*;

public class Main {
    private static PacienteService pacienteService = new PacienteServiceImpl(new PacienteRepositoryImpl());

    public static void main(String[] args) {
        // Probando que sirve la funcion de agregacion pero falta agregarla al menu de opciones
        Paciente carlos = new Paciente("Carlos Arturo", "Baron Estrada", 19, "Masculino", "Placer", "3183487086");
        Cita cita1 = new Cita("20 sep 2024", "5:00 pm", "Dolor de cabeza", carlos);
        System.out.println(cita1);

        carlos.agregarCita(cita1);
        System.out.println(carlos.getCitas());
        // ==================================

        int opcion;
        do {
            String menu = "1. Registrar Paciente\n"
                    + "2. Mostrar Pacientes\n"
                    + "3. Salir\n"
                    + "Seleccione una opción:";
            String opcionStr = JOptionPane.showInputDialog(null, menu, "Menú", JOptionPane.PLAIN_MESSAGE);

            // Manejar si el usuario cierra la ventana o cancela
            if (opcionStr == null) {
                break;  // Salir si se cancela o cierra el cuadro de diálogo
            }

            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1 -> registrarPaciente();
                case 2 -> mostrarPacientes();
                case 3 -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }

    private static void registrarPaciente() throws NumberFormatException {
        try {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre:", "Registro de Paciente", JOptionPane.PLAIN_MESSAGE);
            if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre no puede estar vacío");

            String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido:", "Registro de Paciente", JOptionPane.PLAIN_MESSAGE);
            if (apellido == null || apellido.isEmpty()) throw new IllegalArgumentException("Apellido no puede estar vacío");

            String edadStr = JOptionPane.showInputDialog(null, "Ingrese la edad:", "Registro de Paciente", JOptionPane.PLAIN_MESSAGE);
            int edad = Integer.parseInt(edadStr);

            String genero = JOptionPane.showInputDialog(null, "Ingrese el género:", "Registro de Paciente", JOptionPane.PLAIN_MESSAGE);
            if (genero == null || genero.isEmpty()) throw new IllegalArgumentException("Género no puede estar vacío");

            String direccion = JOptionPane.showInputDialog(null, "Ingrese la dirección:", "Registro de Paciente", JOptionPane.PLAIN_MESSAGE);
            if (direccion == null || direccion.isEmpty()) throw new IllegalArgumentException("Dirección no puede estar vacía");

            String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono:", "Registro de Paciente", JOptionPane.PLAIN_MESSAGE);
            if (telefono == null || telefono.isEmpty()) throw new IllegalArgumentException("Teléfono no puede estar vacío");

            Paciente paciente = new Paciente(nombre, apellido, edad, genero, direccion, telefono);
            pacienteService.registrarPaciente(paciente);

            JOptionPane.showMessageDialog(null, "Paciente registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarPacientes() {
        StringBuilder pacientesList = new StringBuilder();
        for (Paciente paciente : pacienteService.listarPacientes()) {
            pacientesList.append(paciente).append("\n");
        }

        JOptionPane.showMessageDialog(null, pacientesList.length() > 0 ? pacientesList.toString() : "No hay pacientes registrados.", "Lista de Pacientes", JOptionPane.INFORMATION_MESSAGE);
    }
}