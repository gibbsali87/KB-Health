package controllers;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;
import models.Exercise;
import models.Exerciselist;
import models.User;
import models.UserDetails;
import play.Logger;
import play.mvc.Controller;

import java.lang.reflect.Member;
import java.util.List;

public class Members extends Controller
{
  public static void signup()
  {
    render("signup.html");
  }

  public static void login()
  {
    render("login.html");
  }

  public static void register(String firstname, String lastname, String email, String password, String address, float height, float weight, String gender, String chosenPackage)
  {
    Logger.info("Registering new user " + email);
    UserDetails user = new UserDetails(firstname, lastname,gender, email, password, address, height, weight,  chosenPackage);
    user.save();
    redirect("/");
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
    if (session.contains("logged_in_Userid")) {
      String userId = session.get("logged_in_Userid");
      user = User.findById(Long.parseLong(userId));
    } else {
      login();
    }
    return user;
  }

  public static void getMemberDetails()
  {
    Logger.info("Rendeing MemberDetails");
    List<User> memberlist = User.findAll();
    render("memberdetails.html", memberlist);
  }
}