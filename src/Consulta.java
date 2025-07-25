public class Consulta {
    private String id;
    private String dueno;
    private String mascota;
    private String sintomas;
    private String motivos;

    // Constructor
    public Consulta(String id, String dueno, String mascota, String sintomas, String motivos) {
        this.id = id;
        this.dueno = dueno;
        this.mascota = mascota;
        this.sintomas = sintomas;
        this.motivos = motivos;
    }

    // Getters
    public String getId() { return id; }
    public String getDueno() { return dueno; }
    public String getMascota() { return mascota; }
    public String getSintomas() { return sintomas; }
    public String getMotivos() { return motivos; }
}

