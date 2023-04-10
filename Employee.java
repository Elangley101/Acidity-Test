/**
 * This class represents employee
 */
public class Employee {

    private String firstName;
    private String lastName;
    private String email;

    /**
     * Default constructor
     */
    public Employee() {
    }

    /**
     * Parameterized constructor
     *
     * @param firstName First name
     * @param lastName  Last name
     * @param email     Email
     */
    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * String representation of the Employee class
     *
     * @return String representation
     */
    @Override
    public String toString() {

        return String.format("Employee:\nFirst name: %s\nLast name: %s\nEmail:%s\n", firstName, lastName, email);

    }
}
