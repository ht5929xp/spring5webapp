package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Home {
    private int sqft;
    private String address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "owner_home", joinColumns = @JoinColumn(name = "home_id"), inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<Owner> owners = new HashSet<>();
    @ManyToOne
    private Contractor contractor;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Home() {
    }

    public Home(int sqft, String address) {
        this.sqft = sqft;
        this.address = address;
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Home{" +
                "sqft=" + sqft +
                ", address='" + address + '\'' +
                ", contractor=" + contractor +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Home home = (Home) o;

        return Objects.equals(id, home.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getSqft() {
        return sqft;
    }

    public void setSqft(int sqft) {
        this.sqft = sqft;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
