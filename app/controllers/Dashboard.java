package controllers;

import models.Exerciselist;
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
    List<Exerciselist> exerciselists;
    exerciselists = user.exerciselists;
    render ("dashboard.html", exerciselists);
  }

  public static void deleteExerciselist (Long id)
  {
    User user = getLoggedInUser();
    Exerciselist exerciselist = Exerciselist.findById(id);
    user.exerciselists.remove(exerciselist);
    user.save();
    exerciselist.delete();
    redirect ("/dashboard");
  }

  public static void addExerciselist (String name)
  {
    User user = getLoggedInUser();
    Exerciselist exerciselist = new Exerciselist (name, 0);
    Logger.info ("Adding a new exerciselist called " + name);
    user.exerciselists.add(exerciselist);
    user.save();
    redirect ("/dashboard");
  }

}


