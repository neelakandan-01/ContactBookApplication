//Contact book user interface

import java.util.*;

public class ContactUI {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flow = true;
        Contactserver server1 = Contactserver.getServerobject("admin", "admin@123");
       
        System.out.println("Welcome to Contact book login Page :) ");
        System.out.println("Enter Username");
        String username = sc.next();
        System.out.println("Enter Password");
        String password = sc.next();
        if (username.equals(server1.getUsername())
                && password.equals(server1.getPassword())) {
            do {
                System.out.println("**************************");
                System.out.println("Select Your Choice ");
                System.out.println("**************************");
                System.out.println(
                        "1.ADD CONTACT\n2.EDIT CONTACT\n3.DELETE CONTACT\n4.SEARCH CONTACT\n5.LIST ALL CONTACTS\n6.STORAGE STATUS\n7.LIST PERSONAL CONTACT\n8.LIST BUSINESS CONTACT\n9.EXIT");
                System.out.println("**************************");
                int input = sc.nextInt();
                switch (input) {
                    case 1: {
                        System.out.println("Enter NAME");
                        String name = sc.next();
                        System.out.println("Enter CONTACT number");
                        long contact = sc.nextLong();
                        System.out.println("PURPOSE(personal or business)");
                        String purpose = sc.next();
                        server1.addContact(Contact.getContactobject(name, contact, purpose));
                        break;
                    }
                    case 2: {
                        boolean editflow = true;
                        do {
                            System.out.println("Select Your Choice");
                            System.out.println("1.Edit name\n2.Edit phone number\n3.Edit purpose\n4.exit");
                            int inp = sc.nextInt();
                            switch (inp) {
                                case 1: {
                                    System.out.println("Enter Existing name");
                                    server1.editcontactName(sc.next());
                                    break;
                                }
                                case 2: {
                                    System.out.println("Enter contact number");
                                    server1.editcontactNumber(sc.nextLong());
                                    break;
                                }
                                case 3: {
                                    System.out.println("Enter contact name ");
                                    server1.editcontactPurpose(sc.next());
                                    break;
                                }
                                case 4: {
                                    editflow = false;
                                    break;
                                }
                                default:
                                    System.out.println("Invalid Selection :( ");
                                    break;
                            }
                        } while (editflow);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter Existing Contact name");
                        server1.deletecontact(sc.next());
                        break;
                    }
                    case 4: {
                        System.out.println("Enter Contact name");
                        server1.Searchcontact(sc.next());
                        break;
                    }
                    case 5: {
                        server1.getallcontactlist();
                        break;
                    }
                    case 6: {
                        server1.storagestatus();
                        break;
                    }
                    case 7: {
                        server1.listpersonalcontact();
                        break;
                    }
                    case 8: {
                        server1.listbusinesscontact();
                        break;
                    }
                    case 9: {
                        flow = false;
                        break;
                    }
                    default:
                        System.out.println("Invalid Selection :(");
                        break;
                }
            } while (flow);
        } else {
            System.out.println("Invalid username and password");
        }

    }
}
