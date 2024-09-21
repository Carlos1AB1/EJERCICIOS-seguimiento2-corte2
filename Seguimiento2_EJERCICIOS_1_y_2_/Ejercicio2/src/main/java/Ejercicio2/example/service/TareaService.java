package Ejercicio2.example.service;

import Ejercicio2.example.domain.Tarea;
import Ejercicio2.example.infraestructure.repository.TareaRepository;
import java.util.List;


public class TareaService {
    private final TareaRepository repository = new TareaRepository();

    public void agregarTarea(Tarea tarea) {
        List<Tarea> tareas = repository.cargarTareas();
        tareas.add(tarea);
        repository.guardarTareas(tareas);
    }

    public List<Tarea> obtenerTareas() {
        return repository.cargarTareas();
    }

    // Otros métodos para actualizar y eliminar tareas...
}

