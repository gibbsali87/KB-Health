package controllers;

import models.User;
import play.Logger;
import play.mvc.Controller;

import java.util.List;


public class Member extends Controller{

    public static void index() {
        Logger.info("Rendering Member");
        List<User> memberlist = User.findAll();
        render("member.html", memberlist);
    }

    public static void addUser(String name, String email, String address, String gender, String memberShip, String password)
    {
        User member = new User();
        member.setName(name);
        member.setEmail(email);
        member.setAddress(address);
        member.setGender(gender);
        member.setMemberShip("Member");
        member.setPassword(password);
        member.save();
        Logger.info("Adding Member" + name + " " + email + " " + address + " " + gender);
        redirect("/member");
    }
}
