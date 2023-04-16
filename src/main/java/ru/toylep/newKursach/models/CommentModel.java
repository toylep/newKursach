package ru.toylep.newKursach.models;

import lombok.Data;

@Data
public class CommentModel {
    private Long id;
    private String text;
    private Long descriptionID;
    private Long userID;
}
