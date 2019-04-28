package controllers;


import models.User;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Members extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard 1");
    User user = getLoggedInUser();
    List<User> userlists = user.userlists;
    render ("memberdetails.html", userlists);
  }
  public static void signup()
  {
    render("signup.html");
  }

  public static void login()
  {
    render("login.html");
  }

  public static void register(Long id, String firstname, String lastname, String email, String password, String address, float height, float weight, String gender, String chosenPackage, String comment)
  {
    User userlist = new User (id,firstname, lastname,gender, email, password, address, height, weight,  chosenPackage, comment);
    Logger.info ("Adding a new userlist called " + firstname);
    userlist.userlists.add(userlist);
    userlist.save();
    redirect ("/dashboard");
  }


  public static void authenticate(String email, String password)
  {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    User user = User.findByEmail(email);
    if ((user != null) && (user.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Userid", user.id);
      redirect ("/dashboard");
    } else {
      Logger.info("Authentication failed");
      redirect("/login");
    }
  }

  public static void logout()
  {
    session.clear();
    redirect ("/");
  }

  public static User getLoggedInUser()
  {
    User member = null;
    if (session.contains("logged_in_Userid")) {
      String userId = session.get("logged_in_Userid");
      member = User.findById(Long.parseLong(userId));
    } else {
      login();
    }
    return member;
  }
}