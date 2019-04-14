package controllers;

import models.Person;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Trainer extends Controller
{
  public static void index() {
    Logger.info("Rendering Member");
    List<Person> trainerlist = Person.findAll();
    render("trainer.html", trainerlist);
  }

  public static void addPerson(String name, String email, String address, String gender, String memberShip)
  {
    Person trainer = new Person(); //(name, email, address, gender);
    trainer.setName(name);
    trainer.setEmail(email);
    trainer.setAddress(address);
    trainer.setGender(gender);
    trainer.setMemberShip("Trainer");
    trainer.save();
    Logger.info("Adding Trainer " + name + " " + email + " " + address + " " + gender);
    redirect("/trainer");
  }


}
