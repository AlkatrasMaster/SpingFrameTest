package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO: Сервисы. Аннотация @Service  ,
 */
@AllArgsConstructor
@Getter
@Setter
public class CommentDto {
    private Integer id;
    private String text;
    private String author;
}
