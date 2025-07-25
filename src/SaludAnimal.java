public class SaludAnimal {
    private String id;
    private String dueno;
    private String alimentacion;
    private String medicacion;

    public SaludAnimal(String id, String dueno, String alimentacion, String medicacion) {
        this.id = id;
        this.dueno = dueno;
        this.alimentacion = alimentacion;
        this.medicacion = medicacion;
    }

    public String getId() { return id; }
    public String getDueno() { return dueno; }
    public String getAlimentacion() { return alimentacion; }
    public String getMedicacion() { return medicacion; }

    public void setDueno(String dueno) { this.dueno = dueno; }
    public void setAlimentacion(String alimentacion) { this.alimentacion = alimentacion; }
    public void setMedicacion(String medicacion) { this.medicacion = medicacion; }
}
