package controllers;

import java.util.List;

import models.Exerciselist;
import models.Exercise;
import play.Logger;
import play.mvc.Controller;

public class MemberDetails extends Controller
{
  public static void index(Long id)
  {
    Exerciselist exerciselist = Exerciselist.findById(id);
    Logger.info ("Exerciselist id = " + id);
    render("memberDetails.html", exerciselist);
  }

  public static void deleteexercise (Long id, Long exerciseid)
  {
    Exerciselist exerciselist = Exerciselist.findById(id);
    Exercise exercise = Exercise.findById(exerciseid);
    Logger.info ("Removing" + exercise.type);
    exerciselist.exerciseDetails.remove(exercise);
    exerciselist.save();
    exercise.delete();
    render("memberDetails.html", exerciselist);
  }

  public static void addExercise(Long id, String type, String location, int duration)
  {
    Exercise exercise = new Exercise(type, location, duration);
    Exerciselist exerciselist = Exerciselist.findById(id);
    exerciselist.exerciseDetails.add(exercise);
    exerciselist.save();
    redirect ("/exerciselists/" + id);
  }
}