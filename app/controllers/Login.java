package controllers;

import models.User;
import play.Logger;
import play.mvc.Controller;

public class Login extends Controller
{/*
  public static void signup()
  {
    render("signup.html");
  }
  public static void register(String firstname, String lastname, String email, String password)
  {
    Logger.info("Registering new user " + email);
    User user = new User(firstname, lastname, email, password);
    user.save();
    redirect("/");
  }*/

  public static void login()
  {
      render("login.html");
  }

  public static void authenticate(String email, String password)
  {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    User user = User.findByEmail(email);
    if ((user != null) && (user.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", user.id);
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

  public static User getLoggedInMember()
  {
    User user = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      user = User.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return user;
  }
}