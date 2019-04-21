package controllers;

import java.util.List;

import models.Exercise;
import play.mvc.Controller;

public class Trainer extends Controller
{
  public static void index()
  {
    List<Exercise> exercises = Exercise.findAll();
    render("trainer.html", exercises);
  }
}
