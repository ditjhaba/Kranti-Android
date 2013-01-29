package model;

public class Issue {
    private String title;
    private String description;
    private String location;

    public Issue(String title, String description, String location) {
        this.title = title;
        this.description = description;
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

}
