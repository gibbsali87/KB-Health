package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Login extends Controller
{
  public static void index() {
    Logger.info("Rendering login");
    render ("login.html");
  }
}