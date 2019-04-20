package models;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User extends Model {
    private String name;
    private String email;
    private String address;
    private String gender;
    private String memberShip;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Exerciselist> exerciseDetails = new ArrayList<Exerciselist>();

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
    public void setPassword(String password) {
        this.password = password;
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
    public String getPassword(){
       return password;
    }

    public static User findByEmail(String email)
    {
        return find("email", email).first();
    }
    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }
    



}
