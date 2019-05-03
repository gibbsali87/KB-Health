package controllers;


import java.util.List;

import models.Assessment;

import play.Logger;
import play.mvc.Controller;



public class Trainer extends Controller
{
  public static void index(Long id)
  {
    Logger.info("Rendering Trainer");
    List<Assessment> assessments = Assessment.findAll();
    render("trainer.html", assessments);
  }

}
