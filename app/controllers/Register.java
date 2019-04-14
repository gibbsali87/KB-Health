package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Register extends Controller
{
  public static void index() {
    Logger.info("Rendering Register");
    render ("register.html");
  }
}
