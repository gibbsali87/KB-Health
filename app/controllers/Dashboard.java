package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering dashboard");
    render ("dashboard.html");
  }
}