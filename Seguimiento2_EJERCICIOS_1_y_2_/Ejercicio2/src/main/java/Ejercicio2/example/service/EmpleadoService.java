package Ejercicio2.example.service;
import Ejercicio2.example.infraestructure.repository.EmpleadoRepository;
import Ejercicio2.example.domain.Empleado;

import java.util.List;

public class EmpleadoService {
    private final EmpleadoRepository repository = new EmpleadoRepository();

    public void agregarEmpleado(Empleado empleado) {
        List<Empleado> empleados = repository.cargarEmpleados();
        empleados.add(empleado);
        repository.guardarEmpleados(empleados);
    }

    public List<Empleado> obtenerEmpleados() {
        return repository.cargarEmpleados();
    }

    // Otros métodos para actualizar y eliminar empleados...
}

