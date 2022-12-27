package guru.springframework.spring5webapp.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contractInfo")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private int zip;

    @OneToMany
    @JoinColumn(name = "contractor_id")
    private Set<Home> homes;

    public Contractor() {
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "id=" + id +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }

    public Contractor(String addressLine1, String addressLine2, String city, String state, int zip) {
        this.id = id;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
