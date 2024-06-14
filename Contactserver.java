//Contact Server
import java.util.*;

public class Contactserver {
    static Scanner sc = new Scanner(System.in);
    private Contact[] contacts = new Contact[10];
    private String username;
    private String password;

    public Contactserver(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static Contactserver getServerobject(String username, String password) {
        return new Contactserver(username, password);
    }

    public void getallcontactlist() {
        boolean cont_notpresnt = true;
        for (int i = 0; i < contacts.length - 1; i++) {
            if (contacts[i] != null) {
                for (int j = 0; j < contacts.length - 1; j++) {
                    if (contacts[j] != null && contacts[j + 1] != null) {
                        if (contacts[j].getName().charAt(0) > contacts[j + 1].getName().charAt(0)) {
                            Contact temp = contacts[j];
                            contacts[j] = contacts[j + 1];
                            contacts[j + 1] = temp;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                contacts[i].detailsofcontact();
                System.out.println("****************");
                cont_notpresnt = false;
            }
        }
        if (cont_notpresnt) {
            System.out.println("Contact is not there");
        }
    }

    public void Searchcontact(String name) {
        boolean cont_presnt = true;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (contacts[i].getName().equals(name)) {
                    contacts[i].detailsofcontact();
                    cont_presnt = false;
                }
            }
        }
        if (cont_presnt == true) {
            System.out.println("Contact is not there!!!");
        }
    }

    public void addContact(Contact a) {
        boolean cont_full = true;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                contacts[i] = a;
                System.out.println(contacts[i].getName() + " contact added sucessfully");
                cont_full = false;
                break;
            }
        }
        if (cont_full == true) {
            System.out.println("Storage is Already full");
        }
    }

    public void editcontactName(String name) {
        boolean cont_presnt = true;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (contacts[i].getName().equals(name)) {
                    System.out.println("Enter new Name");
                    contacts[i].setName(sc.next());
                    System.out.println("Contact name successfully Edited ");
                    cont_presnt = false;
                    break;
                }
            }
        }
        if (cont_presnt == true) {
            System.out.println("Contact is not there!!!");
        }
    }

    public void editcontactNumber(long contact) {
        boolean cont_presnt = true;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (contacts[i].getContact() == contact) {
                    System.out.println("Enter new Contact");
                    contacts[i].setContact(sc.nextLong());
                    System.out.println("Contact number edited successfully");
                    cont_presnt = false;
                    break;
                }
            }
        }
        if (cont_presnt == true) {
            System.out.println("Contact is not there!!!");
        }
    }

    public void editcontactPurpose(String name) {
        boolean cont_presnt = true;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (contacts[i].getName().equals(name)) {
                    System.out.println("Enter Purpose(personal or business)");
                    contacts[i].setPurpose(sc.next());
                    System.out.println("Contact Purpose successfully Edited ");
                    cont_presnt = false;
                    break;
                }
            }
        }
        if (cont_presnt == true) {
            System.out.println("Contact is not there!!!");
        }
    }

    public void deletecontact(String name) {
        boolean cont_presnt = true;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (contacts[i].getName().equals(name)) {
                    contacts[i] = null;
                    System.out.println("Contact Deleted Succesfully");
                    cont_presnt = false;
                }
            }
        }
        if (cont_presnt == true) {
            System.out.println("Contact is not there");
        }
    }

    public void storagestatus() {
        System.out.println("Total Storage space  is : " + contacts.length);
        int count = 0;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                count++;
            }
        }
        System.out.println("Storage Occupied : " + count);
        System.out.println("Storage Empty space is : " + (contacts.length - count));
    }

    public void listpersonalcontact() {
        boolean cont_notpresnt = true;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (contacts[i].getPurpose().equals("personal")) {
                    contacts[i].detailsofcontact();
                    System.out.println("****************");
                    cont_notpresnt = false;
                }
            }
        }
        if (cont_notpresnt) {
            System.out.println("Personal Contact is not present");
        }
    }

    public void listbusinesscontact() {
        boolean cont_notpresnt = true;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (contacts[i].getPurpose().equals("business")) {
                    contacts[i].detailsofcontact();
                    System.out.println("****************");
                    cont_notpresnt = false;
                }
            }
        }
        if (cont_notpresnt) {
            System.out.println("Business Contact is not present");
        }
    }
}
