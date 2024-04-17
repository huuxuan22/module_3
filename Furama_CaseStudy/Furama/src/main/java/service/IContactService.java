package service;

import model.ContactData.Contact;

import java.util.List;

public interface IContactService {
    List<Contact> selectAllContact();
    boolean deleteContact(int id);
}
