package models;
import play.db.jpa.Model;
import javax.persistence.Entity;


@Entity
public class Person extends Model {
    private String name;
    private String email;
    private String address;
    private String gender;
    private String memberShip;

    /*
    public Person(String name, String email, String address, String gender) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }
    */

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMemberShip(String memberShip) {
        this.memberShip = memberShip;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getMemberShip() {
        return memberShip;
    }
}