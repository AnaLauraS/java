package model;

    import java.time.LocalDate;

    public class Paciente {

        private Long id;
        private String nombre;
        private String apellido;
        private int dni;
        private LocalDate fecha_ingreso;
        private Domicilio domicilio;

        public Paciente(Long id, String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.fecha_ingreso = fechaIngreso;
            this.domicilio = domicilio;
        }

        public Paciente(String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.fecha_ingreso = fechaIngreso;
            this.domicilio = domicilio;
        }

        public LocalDate getFecha_ingreso() {
            return fecha_ingreso;
        }

        public void setFecha_ingreso(LocalDate fecha_ingreso) {
            this.fecha_ingreso = fecha_ingreso;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getDni() {
            return dni;
        }

        public void setDni(int dni) {
            this.dni = dni;
        }

        public LocalDate getFechaIngreso() {
            return fecha_ingreso;
        }

        public void setFechaIngreso(LocalDate fechaIngreso) {
            this.fecha_ingreso = fechaIngreso;
        }

        public Domicilio getDomicilio() {
            return domicilio;
        }

        public void setDomicilio(Domicilio domicilio) {
            this.domicilio = domicilio;
        }
    }
