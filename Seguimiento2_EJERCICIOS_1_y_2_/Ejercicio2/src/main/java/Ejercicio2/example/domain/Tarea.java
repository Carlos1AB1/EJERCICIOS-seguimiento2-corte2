package Ejercicio2.example.domain;
import java.io.Serializable;
import java.util.Date;

public class Tarea implements Serializable {
    private String titulo;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private Empleado empleado;

    // Constructor
    public Tarea(String titulo, String descripcion, Date fechaInicio, Date fechaFin, String estado, Empleado empleado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.empleado = empleado;
    }

    // Getters y Setters
    //

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("Tarea: %s, Estado: %s, Asignada a: %s",
                titulo, estado, empleado.getNombre());
    }
}

