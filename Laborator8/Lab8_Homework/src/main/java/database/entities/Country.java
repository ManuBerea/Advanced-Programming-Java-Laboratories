package database.entities;

public class Country {
    private int id;
    private String name;
    private int code;
    private String continent;

    public Country() {

    }

    public Country(int id, String name, int code, String continent) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getContinent() {
        return continent;
    }
}
