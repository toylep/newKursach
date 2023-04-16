package ru.toylep.newKursach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.toylep.newKursach.DAO.DescriptionDAO;
import ru.toylep.newKursach.models.DescriptionModel;
import ru.toylep.newKursach.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/desc")
public class DescriptionController {
    @Autowired
    private DescriptionDAO descriptionDAO;
    @GetMapping("/find")
    public List<DescriptionModel> findAll(){

        return descriptionDAO.showDescriptions();
     //   result.add(descriptionDAO.showAuthor());
    }
    @PostMapping("/add")
    public String add(@RequestBody DescriptionModel description,
                      @RequestBody UserModel me) {
        descriptionDAO.addDescription(description,me);
        return "success";
    }

}
