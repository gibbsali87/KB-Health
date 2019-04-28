package controllers;



import models.Exerciselist;
import models.Exercise;
import play.Logger;
import play.mvc.Controller;

public class ExerciseDetails extends Controller
{
 public static void index(Long id)
  {
    Exerciselist exerciselist = Exerciselist.findById(id);
    Logger.info ("Exerciselist id = " + id);
    render("exerciselist.html", exerciselist);
  }



  public static void deleteExercise (Long id, Long exerciseid)
  {
    Exerciselist exerciselist = Exerciselist.findById(id);
    Exercise exercise = Exercise.findById(exerciseid);
    Logger.info ("Removing" + exercise.name);
    exerciselist.exercises.remove(exercise);
    exerciselist.save();
    exercise.delete();
    render("exerciselist.html", exerciselist);
  }

  public static void addExercise(Long id, String name, String location, int duration)
  {
    Exercise exercise = new Exercise(name, location, duration);
    Exerciselist exerciselist = Exerciselist.findById(id);
    exerciselist.exercises.add(exercise);
    exerciselist.save();
    redirect ("/exerciselists/" + id);
  }

}
