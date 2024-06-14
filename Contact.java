//Contact
public class Contact {
    private String name;
    private long contact;
    private String purpose;

    public Contact(String name, long contact, String purpose) {
        this.name = name;
        this.contact = contact;
        this.purpose = purpose;
    }

    public String getName() {   
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public static Contact getContactobject(String name, long contact, String purpose) {
        return new Contact(name, contact, purpose);
    }

    public void detailsofcontact() {
        System.out.println("Name is : " + getName());
        System.out.println("Contact is : " + getContact());
        System.out.println("Contact purpose : " + getPurpose());
    }

}
