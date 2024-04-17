package model.ContactData;

public class Contact {
    protected String contactId;
    protected String startDate;
    protected String endDate;
    protected int money;
    protected String employeeName;
    protected String customerName;
    protected String serviceName;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Contact(String contactId, String startDate, String endDate, int money, String employeeName, String customerName, String serviceName) {
        this.contactId = contactId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.money = money;
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.serviceName = serviceName;
    }
}
