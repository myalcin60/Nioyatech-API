package pojoDatas;

public class UserGroupTypeServicesPojo {
    private String id;
    private String name;
    private String description;

    public UserGroupTypeServicesPojo() {
    }

    public UserGroupTypeServicesPojo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public UserGroupTypeServicesPojo(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

//    @Override
//    public String toString() {
//        return "{\"id\": \"" + id + "\",\"name\": \"" + name + "\", \"description\": \"" + description + "\"}";
//    }


    @Override
    public String toString() {
        return "UserGroupTypeServicesPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
