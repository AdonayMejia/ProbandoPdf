package alcaldia.soyapango.app.Model;

import java.io.Serializable;


public class RevistaResponse implements Serializable{
    private int id;
    private String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "RevistaResponse{" +
                "id=" + id +
                ", Name='" + Name +
                '}';
    }
}
