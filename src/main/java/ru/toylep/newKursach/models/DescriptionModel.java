package ru.toylep.newKursach.models;

import lombok.Data;

@Data
public class DescriptionModel {
    private Long id;
    private String subjectName;
    private String teacherFIO;
    private String text;
    private String specLinks;
    private Long userID;
}
