package controllers;


import models.Assessment;
import models.Comment;
import models.Commentlist;
import models.User;
import play.Logger;
import play.mvc.Controller;
import java.util.Date;
import java.util.List;

import static controllers.Members.getLoggedInUser;


public class AssessmentDetails extends Controller
{
    public static void index()
    {
        User user = getLoggedInUser();
        Assessment assessment = (Assessment) user.assessments;
        Logger.info ("Assessment User = " + user.firstname);
        render("trainer.html", assessment);
    }

    public static void deleteAssessment (Long assessmentid)
    {
        User user = getLoggedInUser();
        Assessment assessment = Assessment.findById(assessmentid);
        Logger.info ("Removing " + assessmentid);
        user.assessments.remove(assessment);
        render("trainer.html", assessment);
    }

    public static void addAssessment(Long id, Date date,float weight,float chest,float thigh,float upperArm,float waist,float hips, String comment)
    {
        User user = getLoggedInUser();
        Assessment assessment = new Assessment(date,weight,chest,thigh,upperArm,waist,hips,comment);
        user.assessments.add(assessment);
        assessment.save();
        redirect ("/dashboard");
    }

}
