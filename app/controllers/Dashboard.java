package controllers;

import java.util.ArrayList;
import java.util.List;

import models.User;
import models.Exerciselist;
import models.Exercise;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index() 
  {
    Logger.info("Rendering Dasboard");
    User user = Login.getLoggedInMember();
    List<Exerciselist> exerciseDetails = user.exerciseDetails;
    render ("dashboard.html", exerciseDetails);
  }

  public static void deleteExerciselist (Long id)
  {
    Logger.info("Deleting a Exerciselist");
    User user = Login.getLoggedInMember();
    Exerciselist exerciselist = Exerciselist.findById(id);
    user.exerciseDetails.remove(exerciselist);
    user.save();
    exerciselist.delete();
    redirect ("/dashboard");
  }

  public static void addExerciselist (String type)
  {
    Logger.info("Adding a Exerciselist");
    User user = Login.getLoggedInMember();
    Exerciselist exerciselist = new Exerciselist (type, 0);
    user.exerciseDetails.add(exerciselist);
    user.save();
    redirect ("/dashboard");
  }
}

