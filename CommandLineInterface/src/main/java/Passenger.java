public class Passenger {
    private String name;
    private long contactInfo;
    private int id;

    public Passenger(String name, long contactInfo, int id){
        this.name=name;
        this.contactInfo=contactInfo;
        this.id=id;
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
