package controllers;

import models.Assessmentlist;
import models.User;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

import static controllers.Members.*;

public class Dashboard extends Controller
{
  public static void index() 
  {
    Logger.info("Rendering Dashboard");
    User user = getLoggedInUser();
    List<Assessmentlist> assessmentlists = user.assessmentlists;
    render ("dashboard.html", assessmentlists);
  }

  public static void deleteAssessmentlist (Long id)
  {
    User user = getLoggedInUser();
    Assessmentlist assessmentlist = Assessmentlist.findById(id);
    user.assessmentlists.remove(assessmentlist);
    user.save();
    assessmentlist.delete();
    redirect ("/dashboard");
  }

  public static void addAssessmentlist (int week)
  {
    User user = getLoggedInUser();
    Assessmentlist assessmentlist = new Assessmentlist (week);
    Logger.info ("Adding a new assessmentlist called " + week);
    user.assessmentlists.add(assessmentlist);
    user.save();
    redirect ("/dashboard");
  }

}


