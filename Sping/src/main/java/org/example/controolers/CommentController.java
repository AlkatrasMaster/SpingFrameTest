package org.example.controolers;


import org.example.dto.CommentDto;
import org.example.services.CommentCRUDServices;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


/**
 * TODO: Сервисы. Аннотация @Service  ,
 */

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentCRUDServices commentServices;

    public CommentController(CommentCRUDServices commentServices) {
        this.commentServices = commentServices;
    }

    @GetMapping("/{id}")
    public CommentDto getCommentById(@PathVariable Integer id) {
        return commentServices.getById(id);

    }

    @GetMapping
    public Collection<CommentDto> getAllComments() {
        return commentServices.getAll();
    }

    @PostMapping
    public void createComment(@RequestBody CommentDto commentDto) {
        commentServices.create(commentDto);

    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Integer id, @RequestBody CommentDto commentDto) {
        commentServices.update(id, commentDto);

    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentServices.delete(id);
    }
}
