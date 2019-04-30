package controllers;

import models.Assessment;
import org.joda.time.DateTime;
import play.Logger;
import play.mvc.Controller;

import java.util.Date;
import java.util.List;

public class AssessmentDetails extends Controller{

    public static void index(Long id)
    {
        List<Assessment> assessment = Assessment.findAll();
        Logger.info ("Assessment id = " + id);
        render("assessment.html", assessment);
    }

    public static void addAssessment(Long id, Date date, float height, float weight, float chest, float thigh, float upperArm, float waist, float hips)
    {
        Logger.info ("Assessment Details");
        Assessment assessment = new Assessment(id,date,height,weight,chest,thigh,upperArm,waist,hips);
        assessment.save();
        render("assessment.html", assessment);
    }
}
