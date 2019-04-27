package controllers;

import models.Exerciselist;
import models.User;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index() 
  {
    Logger.info("Rendering Dashboard");
   User user = Members.getLoggedInMember();
   List<Exerciselist> exerciselists = user.exerciselists;
//    List <Exerciselist>exerciselists = Exerciselist.findAll();
    render ("dashboard.html", exerciselists);
  }

  public static void deleteExerciselist (Long id)
  {
    User user = Members.getLoggedInMember();
    Exerciselist exerciselist = Exerciselist.findById(id);
    Logger.info ("Removing" + exerciselist.name);
    exerciselist.delete();
    redirect ("/dashboard");
  }

  public static void addExerciselist (String name)
  {
    User user = Members.getLoggedInMember();
    Exerciselist exerciselist = new Exerciselist (name, 0);
    Logger.info ("Adding a new exerciselist called " + name);
    exerciselist.save();
    redirect ("/dashboard");
  }
}

