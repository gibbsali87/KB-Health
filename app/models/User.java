package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User extends Model {
  public String firstname;
  public String lastname;
  public String gender;
  public String email;
  public String password;
  public String address;
  public float height;
  public float startWeight;
  public String chosenPackage;
  public String comment;


  @OneToMany(cascade = CascadeType.ALL)
  public List<Exerciselist> exerciselists = new ArrayList<Exerciselist>();

  @OneToMany(cascade = CascadeType.ALL)
  public List<User> userlists = new ArrayList<User>();

  @OneToMany(cascade = CascadeType.ALL)
  public List<Assessmentlist> assessments = new ArrayList<Assessmentlist>();


    public User(Long id, String firstname, String lastname, String gender, String email, String password, String address, float height, float startWeight, String chosenPackage, String comment) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.gender = gender;
    this.email = email;
    this.password = password;
    this.address = address;
    this.height = height;
    this.startWeight = startWeight;
    this.chosenPackage = chosenPackage;
    this.comment = comment;
  }

  public static User findByEmail(String email) {
    return find("email", email).first();
  }

  public boolean checkPassword(String password) {
    return this.password.equals(password);
  }
}
