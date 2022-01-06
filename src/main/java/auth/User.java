package auth;

/**
 * Create a user with a name and id
 */

public class User {

     private String name;
     private int id, phoneNumber;

    public User(String name, int id, int phoneNumber) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


}
