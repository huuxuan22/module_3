package model.EmployeeData;

public class Employee {
    protected int id;
    protected String employeeName;

    protected String birthday;

    protected String iDCard;
    protected double salary;
    protected String numberPhone;
    protected String email;

    protected String address;
    protected int positionId;
    protected int idEDegree;
    protected int idDivision;
    protected String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getiDCard() {
        return iDCard;
    }

    public void setiDCard(String iDCard) {
        this.iDCard = iDCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getIdEDegree() {
        return idEDegree;
    }

    public void setIdEDegree(int idEDegree) {
        this.idEDegree = idEDegree;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Employee(int id, String employeeName, String birthday, String iDCard, double salary, String numberPhone, String email, String address, int positionId, int idEDegree, int idDivision, String userName) {
        this.id = id;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.iDCard = iDCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.idEDegree = idEDegree;
        this.idDivision = idDivision;
        this.userName = userName;
    }
}
