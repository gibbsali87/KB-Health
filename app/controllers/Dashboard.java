package controllers;

import models.Assessment;
import models.User;
import play.Logger;
import play.mvc.Controller;
import java.util.List;

import static controllers.Members.*;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    User user = getLoggedInUser();
    List<Assessment> assessment = user.assessments;
    Logger.info("Rendering Dashboard 2");
    render("dashboard.html", assessment);
  }

}


