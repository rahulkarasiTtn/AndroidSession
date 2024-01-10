package Exercises.Three;

import java.util.TreeMap;

public class ContactBook {
    TreeMap <String,String> contacts = new TreeMap<String, String>();

    public void addContact(String name, String number){
        contacts.put(name,number);
    }
    public String retrieveContact(String name){
      return  contacts.get(name);
    }
    public void removeContact(String name){
        contacts.remove(name);
    }

    public static void main(String[] args) {
        //Question-4
        ContactBook contactBook = new ContactBook();
        contactBook.addContact("Rahul","7457876321");
        contactBook.addContact("Jasmin","8433025557");
        contactBook.addContact("Arun","8433025557");
        contactBook.addContact("Kiran","8433025557");
        System.out.println(contactBook.retrieveContact("Rahul"));
        contactBook.removeContact("Kiran");
        System.out.println(contactBook.contacts);
    }
}
