package controllers;

import models.Assessment;
import models.Assessmentlist;
import models.User;
import play.Logger;
import play.mvc.Controller;

import java.util.Date;
import java.util.List;

import static controllers.Members.getLoggedInUser;

public class AssessmentDetails extends Controller{
/*
    public static void index(Long id)
    {
        Logger.info("Rendering AssessmentDetails");
        List<Assessmentlist> assessmentlist = Assessmentlist.findAll();
        render ("assessment.html", assessmentlist);
    }

    public static void addAssessment(Long id, Date date, float height, float weight, float chest, float thigh, float upperArm, float waist, float hips)
    {
        Logger.info ("Assessment Details");
        Assessment assessment = new Assessment(id,date,height,weight,chest,thigh,upperArm,waist,hips);
        assessment.save();
        render("assessment.html", assessment);
    }


    public static void addAssessmentlist (String week, Date date)
    {
        Assessmentlist assessmentlist = new Assessmentlist (week, date);
        Logger.info ("Adding a new assessmentlist");
        assessmentlist.save();
        redirect ("/assessment");
    }
*/
public static void index()
{
    Logger.info("Rendering CommentDetails");
    List<Assessmentlist> assessmentlist = Assessmentlist.findAll();
    render ("assessmentdetails.html", assessmentlist);
}

    public static void allAssessments(Long id)
    {
        Assessmentlist assessmentlist = Assessmentlist.findById(id);
        Logger.info ("Commentlist id = " + id);
        render("assessment.html", assessmentlist);
    }

    public static void deleteAssessment (Long id, Long assessmentid)
    {
        Assessmentlist assessmentlist = Assessmentlist.findById(id);
        Assessment assessment = Assessment.findById(assessmentid);
        Logger.info ("Removing" + assessment);
        assessmentlist.assessments.remove(assessment);
        assessmentlist.save();
        assessment.delete();
        render("assessmentlist.html", assessmentlist);
    }

    public static void addAssessment(Long id, Date date, float height, float weight, float chest, float thigh, float upperArm, float waist, float hips)
    {
        Assessment assessments = new Assessment( id,  date,  height,  weight,  chest,  thigh,  upperArm,  waist,  hips);
        Assessmentlist assessmentlist = Assessmentlist.findById(id);
        assessmentlist.assessments.add(assessments);
        assessmentlist.save();
        redirect ("/assessmentlists/" + id);
    }

    public static void addAssessmentlist (String week, Date date)
    {
        Assessmentlist assessmentlist = new Assessmentlist (week, date);
        Logger.info ("Adding a new assessmentlist called " +week);
        assessmentlist.save();
        redirect ("/assessmentdetails");
    }
    public static void deleteAssessmentlist (Long id)
    {
        Assessmentlist assessmentlist = Assessmentlist.findById(id);
        Logger.info ("Deleting" + assessmentlist);
        assessmentlist.delete();
        redirect ("/assessmentdetails");
    }
}
