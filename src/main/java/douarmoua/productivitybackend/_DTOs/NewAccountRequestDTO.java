package douarmoua.productivitybackend._DTOs;

public class NewAccountRequestDTO {
    public String firstName;
    public String lastName;
    public String email;
    public String username;
    public String password;

    @Override
    public String toString() {
        return "NewAccountRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
