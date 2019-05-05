package controllers;

import models.Assessment;
import models.User;
import play.Logger;
import play.mvc.Controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static controllers.Members.*;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    User user = getLoggedInUser();
    List<Assessment> assessment = user.assessments;
    Collections.sort(assessment, new Comparator<Assessment>() {
      public int compare(Assessment o1, Assessment o2) {
        return o1.getDate().compareTo(o2.getDate());
      }
    });
    render("dashboard.html", assessment);
  }

  public static void listallAssessments() {
    Logger.info("Rendering Dashboard");
    List<Assessment> assessment = Assessment.findAll();
    Collections.sort(assessment, new Comparator<Assessment>() {
      public int compare(Assessment o1, Assessment o2) {
        return o1.getDate().compareTo(o2.getDate());
      }
    });
    render("listassessments.html", assessment);
  }

}


