package Repository;

import model.ContactData.Contact;

import java.util.List;

public interface IContactRepo {
    public List<Contact> selectAllContact();
    public boolean deleteContact(int id);
    public void addContactTransaction(Contact contact,List<Integer> permissions);
}
