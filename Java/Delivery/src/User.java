import java.util.ArrayList;

public class User extends Account{
    private String name;
    private int phone;
    private ArrayList<String> history;
    private double rating;
    private static int id =1;

    public User(String userName, String password, String rol, String name, int phone, double rating) {
        super(userName, password, rol);
        this.name = name;
        this.phone = phone;
        this.history = new ArrayList<>();
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public double getRating() {
        return rating;
    }

    public static int getId() {
        return id;
    }
}
