package controllers;

import models.Assessment;
import models.User;
import play.Logger;
import play.mvc.Controller;

import java.util.Date;
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
/*
  public static void addAssessment (Long id, Date date, float weight, float chest, float thigh, float upperArm, float waist, float hips, String comment)
  {
    User user = getLoggedInUser();
    Assessment assessment = new Assessment (date,weight,chest,thigh,upperArm,waist,hips,comment);
    Logger.info ("Adding a new assessmentlist called " + date);
    user.assessments.add(assessment);
    user.save();
    redirect ("/dashboard");
  }
 */

}


