import java.util.Random;

public class Passenger {
    private String name;
    private long contactInfo;
    private int id;

    public Passenger(String name, long contactInfo){
        //min and max value for random id
        int min =10000;
        int max =99999;
        //random id
        int random = (int) Math.floor(Math.random()*(max-min+1)+min);

        this.name=name;
        this.contactInfo=contactInfo;
        this.id=random;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(long contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
