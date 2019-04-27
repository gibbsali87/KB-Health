package controllers;

import models.Exerciselist;
import play.Logger;
import play.mvc.Controller;
import models.Comment;

import java.util.Date;
import java.util.List;

public class Dashboard extends Controller
{
  public static void index() 
  {
    Logger.info("Rendering Dashboard");
    List<Exerciselist> exerciselists = Exerciselist.findAll();
    render ("dashboard.html", exerciselists);
  }

  public static void deleteExerciselist (Long id)
  {
    Exerciselist exerciselist = Exerciselist.findById(id);
    Logger.info ("Removing" + exerciselist.name);
    exerciselist.delete();
    redirect ("/dashboard");
  }

  public static void addExerciselist (String name)
  {
    Exerciselist exerciselist = new Exerciselist (name, 0);
    Logger.info ("Adding a new exerciselist called " + name);
    exerciselist.save();
    redirect ("/dashboard");
  }

  public static void addComment (String comment, Date date)
  {
    Comment comments = new Comment (comment, date);
    Logger.info ("Adding a new comment " + comments);
    comments.save();
    render("memberdetails.html", comments);
  }


}

