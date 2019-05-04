package controllers;


import models.Assessment;
import models.Comment;
import models.User;
import play.Logger;
import play.mvc.Controller;
import java.util.Date;
import static controllers.Members.getLoggedInUser;


public class CommentDetails extends Controller
{
    public static void index()
    {
        Assessment assessment = (Assessment) Assessment.findAll();
        Comment comment = (Comment) assessment.comments;
        Logger.info ("Assessment User = " + assessment.id);
        render("trainer.html", comment);
    }


    public static void addComment(Long id, Date date, String comment)
    {
        Comment trainerComment = new Comment(date,comment);
        Assessment assessment = Assessment.findById(id);
        assessment.comments.add(trainerComment);
        assessment.save();
        redirect ("/trainer");
    }
}

