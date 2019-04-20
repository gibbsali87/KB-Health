package controllers;

import java.util.List;

import models.ExerciseList;
import models.Exercise;
import play.Logger;
import play.mvc.Controller;

public class MemberDetails extends Controller
{
  public static void index(Long id)
  {
    ExerciseList exerciseList = ExerciseList.findById(id);
    Logger.info ("ExerciseList id = " + id);
    render("ExerciseList.html", exerciseList);
  }

  public static void deleteExercise (Long id, Long exerciseid)
  {
    ExerciseList exerciseList = ExerciseList.findById(id);
    Exercise exercise = Exercise.findById(exerciseid);
    Logger.info ("Removing" + exercise.type);
    exerciseList.exerciseDetails.remove(exercise);
    exerciseList.save();
    exercise.delete();
    render("exerciseList.html", exerciseList);
  }

  public static void addExercise(Long id, String type, String location, int duration)
  {
    Exercise exercise = new Exercise(type, location, duration);
    ExerciseList exerciseList = ExerciseList.findById(id);
    exerciseList.exerciseDetails.add(exercise);
    exerciseList.save();
    redirect ("/exerciseList/" + id);
  }
}