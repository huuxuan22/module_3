package model.EmployeeData.dto;

public class EmployeeInsert {
    protected int id;
    protected String employeeName;

    protected String birthday;

    protected String iDCard;
    protected double salary;
    protected String numberPhone;
    protected String email;

    protected String address;
    protected int idEducation;
    protected int idPosition;
    protected int idDivition;

    public EmployeeInsert(int id, String employeeName, String birthday, String iDCard, double salary, String numberPhone, String email, String address, int idEducation, int idPosition, int idDivition) {
        this.id = id;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.iDCard = iDCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.idEducation = idEducation;
        this.idPosition = idPosition;
        this.idDivition = idDivition;

    }

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

    public int getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(int idEducation) {
        this.idEducation = idEducation;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdDivition() {
        return idDivition;
    }

    public void setIdDivition(int idDivition) {
        this.idDivition = idDivition;
    }
}
