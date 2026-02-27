package model;


public class UpdateComputerDTO {
    private Long id;
    private String brand;
    private String version;
    private Long student;

    public UpdateComputerDTO(Long id, String brand, String version, Long student) {
        this.id = id;
        this.brand = brand;
        this.version = version;
        this.student = student;
    }

    public UpdateComputerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }
}
