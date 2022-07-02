package entity;

public class MedicalDeclaration {
    private String name;
    private String birth;
    private String gender;
    private String nation;
    private String id;
    private String transport;
    private String licensePlate;
    private String startDay;
    private String endDay;
    private String route;

    public MedicalDeclaration(){}

    public MedicalDeclaration(String name, String birth, String gender, String nation, String id, String transport,
                              String licensePlate, String startDay, String endDay, String route) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.nation = nation;
        this.id = id;
        this.transport = transport;
        this.licensePlate = licensePlate;
        this.startDay = startDay;
        this.endDay = endDay;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
