package controllers;

import java.util.Date;
import java.util.List;

import models.Commentlist;
import models.Comment;
import play.Logger;
import play.mvc.Controller;

public class CommentDetails extends Controller
{
    public static void index()
    {
        Logger.info("Rendering CommentDetails");
        List<Commentlist> commentlists = Commentlist.findAll();
        render ("commentdetails.html", commentlists);
    }



    public static void deleteComment (Long id, Long commentid)
    {
        Commentlist commentlist = Commentlist.findById(id);
        Comment comment = Comment.findById(commentid);
        Logger.info ("Removing" + comment.comment);
        commentlist.comments.remove(comment);
        commentlist.save();
        comment.delete();
        render("commentlist.html", commentlist);
    }

    public static void addComment(Long id, String comment, Date date)
    {
        Comment comments = new Comment(comment, date);
        Commentlist commentlist = Commentlist.findById(id);
        commentlist.comments.add(comments);
        commentlist.save();
        redirect ("/commentlists/" + id);
    }

    public static void addCommentlist (String comment, Date date)
    {
        Commentlist commentlist = new Commentlist (comment, date);
        Logger.info ("Adding a new commentlist called " + comment);
        commentlist.save();
        redirect ("/commentlist");
    }

}
