package service.impl;

import Repository.IContactRepo;
import Repository.impl.ContactRepo;
import model.ContactData.Contact;
import service.IContactService;

import java.util.List;

public class ContactService implements IContactService{
    private IContactRepo contactRepo = new ContactRepo();
    @Override
    public List<Contact> selectAllContact() {
        return contactRepo.selectAllContact();
    }

    @Override
    public boolean deleteContact(int id) {
        return contactRepo.deleteContact(id);
    }
}
