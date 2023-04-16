package ru.toylep.newKursach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.toylep.newKursach.DAO.CommentDAO;
import ru.toylep.newKursach.models.CommentModel;
import ru.toylep.newKursach.models.UserModel;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    private CommentDAO commentDAO;
    @GetMapping("/find/{id}")
    public List<CommentModel> getCommentByDescriptionId(@PathVariable Long id){
        return commentDAO.searchCommentByDescription(id);

    }
    @PostMapping("/add/{id}")
    public void addCommentToDescription(@PathVariable Long id, @RequestBody CommentModel comment, @RequestBody UserModel user){
        commentDAO.addComment(id,comment,user);
    }


}
