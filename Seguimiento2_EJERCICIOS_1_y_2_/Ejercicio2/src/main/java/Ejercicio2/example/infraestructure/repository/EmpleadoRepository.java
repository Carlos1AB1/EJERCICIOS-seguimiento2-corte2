package Ejercicio2.example.infraestructure.repository;
import Ejercicio2.example.domain.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {
    private final String filePath = "empleados.txt";

    public void guardarEmpleados(List<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> cargarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            empleados = (List<Empleado>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}

