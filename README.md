# Gestión de Pacientes y Empleados en Java

Este repositorio contiene dos programas desarrollados en Java que permiten gestionar la información de pacientes y empleados, así como sus respectivas citas y tareas. Ambos programas utilizan persistencia de datos a través de archivos de texto plano, asegurando que la información se almacene y recupere de manera efectiva.

## Ejercicio 1: Gestión de Pacientes y Citas Médicas

### Descripción
Un programa para gestionar la información de los pacientes y sus citas médicas, proporcionando una interfaz intuitiva para registrar, actualizar y visualizar datos.

### Requisitos
- **Clase Paciente:**
  - Atributos: `nombre`, `apellido`, `edad`, `género`, `dirección`, `teléfono`.
  - Métodos: Getters y setters, y otros métodos según sea necesario.

- **Clase Cita:**
  - Atributos: `fecha`, `hora`, `motivo`, `paciente` (objeto de la clase Paciente).
  - Métodos: Getters y setters, y otros métodos según sea necesario.

- **Clase Principal:**
  - Menú para:
    - Registrar un nuevo paciente.
    - Actualizar datos del paciente.
    - Registrar una nueva cita para un paciente existente.
    - Eliminar una cita asignada.
    - Mostrar la lista de pacientes registrados.
    - Mostrar la lista de citas para un paciente específico.
    - Salir del programa.

### Persistencia de Datos
- Carga la información de pacientes y citas desde archivos al iniciar el programa.
- Actualiza los archivos correspondientes tras cada operación de registro o modificación.

### Manejo de Errores
- Implementación de un manejo adecuado de errores y excepciones para la entrada de datos y la lectura/escritura de archivos.

## Ejercicio 2: Gestión de Empleados y Tareas Asignadas

### Descripción
Un programa que gestiona la información de los empleados y sus tareas asignadas, facilitando la administración de recursos humanos.

### Requisitos
- **Clase Empleado:**
  - Atributos: `nombre`, `apellido`, `edad`, `cargo`, `departamento`, `salario`.
  - Métodos: Getters y setters, y otros métodos según sea necesario.

- **Clase Tarea:**
  - Atributos: `título`, `descripción`, `fechaInicio`, `fechaFin`, `estado`, `empleado` (objeto de la clase Empleado).
  - Métodos: Getters y setters, y otros métodos según sea necesario.

- **Clase Principal:**
  - Menú para:
    - Registrar un nuevo empleado.
    - Actualizar datos del empleado.
    - Asignar una nueva tarea a un empleado existente.
    - Eliminar una tarea asignada.
    - Mostrar la lista de empleados registrados.
    - Mostrar la lista de tareas para un empleado específico.
    - Actualizar el estado de una tarea.
    - Salir del programa.

### Persistencia de Datos
- Carga la información de empleados y tareas desde archivos al iniciar el programa.
- Actualiza los archivos correspondientes tras cada operación de registro o modificación.

### Manejo de Errores
- Implementación de un manejo adecuado de errores y excepciones para la entrada de datos y la lectura/escritura de archivos.

### Requisitos Adicionales
- Función para generar reportes de productividad, mostrando el número de tareas completadas por cada empleado en un período específico.
- Opción en el menú para buscar empleados por departamento.
- Función para calcular el salario total por departamento.

## Conclusión
Este repositorio demuestra habilidades de programación en Java y la capacidad de implementar soluciones efectivas para la gestión de datos mediante persistencia en archivos. Los programas están diseñados para ser fáciles de usar y robustos, garantizando una experiencia confiable para el usuario final.

## Mención
Creado por **Carlos Arturo Baron Estrada**.
