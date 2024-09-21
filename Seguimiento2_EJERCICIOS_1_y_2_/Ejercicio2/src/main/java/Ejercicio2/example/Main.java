package Ejercicio2.example;



import Ejercicio2.example.service.TareaService;
import Ejercicio2.example.domain.Empleado;
import Ejercicio2.example.domain.Tarea;
import Ejercicio2.example.service.EmpleadoService;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmpleadoService empleadoService = new EmpleadoService();
        TareaService tareaService = new TareaService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            String[] options = {"Registrar nuevo empleado", "Asignar tarea a empleado", "Mostrar empleados",
                    "Mostrar tareas de un empleado", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Menú", "Gestión de Empleados",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (opcion) {
                case 0: // Registrar nuevo empleado
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado:"));
                    String cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado:");
                    String departamento = JOptionPane.showInputDialog("Ingrese el departamento del empleado:");
                    double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado:"));

                    Empleado empleado = new Empleado(nombre, apellido, edad, cargo, departamento, salario);
                    empleadoService.agregarEmpleado(empleado);
                    JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente!");
                    break;

                case 1: // Asignar tarea a empleado
                    String titulo = JOptionPane.showInputDialog("Ingrese el título de la tarea:");
                    String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la tarea:");
                    String fechaInicioStr = JOptionPane.showInputDialog("Ingrese la fecha de inicio (dd/MM/yyyy):");
                    String fechaFinStr = JOptionPane.showInputDialog("Ingrese la fecha de fin (dd/MM/yyyy):");
                    String estado = JOptionPane.showInputDialog("Ingrese el estado de la tarea:");

                    Date fechaInicio;
                    Date fechaFin;
                    try {
                        fechaInicio = sdf.parse(fechaInicioStr);
                        fechaFin = sdf.parse(fechaFinStr);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Intente nuevamente.");
                        continue;
                    }

                    // Asumimos que hay un método para buscar empleados por nombre o algún identificador
                    String empleadoNombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado asignado:");
                    Empleado empleadoAsignado = empleadoService.obtenerEmpleados().stream()
                            .filter(emp -> emp.getNombre().equalsIgnoreCase(empleadoNombre))
                            .findFirst().orElse(null);

                    if (empleadoAsignado != null) {
                        Tarea tarea = new Tarea(titulo, descripcion, fechaInicio, fechaFin, estado, empleadoAsignado);
                        tareaService.agregarTarea(tarea);
                        JOptionPane.showMessageDialog(null, "Tarea asignada exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                    }
                    break;

                case 2: // Mostrar empleados
                    List<Empleado> empleados = empleadoService.obtenerEmpleados();
                    StringBuilder empleadosList = new StringBuilder("Empleados registrados:\n");
                    for (Empleado emp : empleados) {
                        empleadosList.append(emp.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, empleadosList.toString());
                    break;

                case 3: // Mostrar tareas de un empleado
                    String nombreEmpleado = JOptionPane.showInputDialog("Ingrese el nombre del empleado para ver sus tareas:");
                    List<Tarea> tareas = tareaService.obtenerTareas();
                    StringBuilder tareasList = new StringBuilder("Tareas de " + nombreEmpleado + ":\n");
                    for (Tarea tarea : tareas) {
                        if (tarea.getEmpleado().getNombre().equalsIgnoreCase(nombreEmpleado)) {
                            tareasList.append(tarea.toString()).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, tareasList.toString());
                    break;

                case 4: // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
}
