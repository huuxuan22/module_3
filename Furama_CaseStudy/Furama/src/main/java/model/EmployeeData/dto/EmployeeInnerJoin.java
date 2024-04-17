package model.EmployeeData.dto;

public class EmployeeInnerJoin {
    protected int id;
    protected String employeeName;

    protected String birthday;

    protected String iDCard;
    protected double salary;
    protected String numberPhone;
    protected String email;

    protected String address;
    protected String nameEducation;
    protected String namePosition;
    protected String nameDivition;
    protected String userName;

    public int getId() {
        return id;
    }

    public EmployeeInnerJoin(int id, String employeeName, String birthday, String iDCard, double salary, String numberPhone, String email, String address, String namePosition, String nameDivition, String nameEducation, String userName) {
        this.id = id;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.iDCard = iDCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.nameEducation = namePosition;
        this.namePosition = nameDivition;
        this.nameDivition = nameEducation;
        this.userName = userName;
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

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public String getNameDivition() {
        return nameDivition;
    }

    public void setNameDivition(String nameDivition) {
        this.nameDivition = nameDivition;
    }

    public String getNameEducation() {
        return nameEducation;
    }

    public void setNameEducation(String nameEducation) {
        this.nameEducation = nameEducation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
