package Ejercicio2.example.infraestructure.repository;
import Ejercicio2.example.domain.Tarea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TareaRepository {
    private final String filePath = "tareas.txt";

    public void guardarTareas(List<Tarea> tareas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(tareas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Tarea> cargarTareas() {
        List<Tarea> tareas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            tareas = (List<Tarea>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tareas;
    }
}

