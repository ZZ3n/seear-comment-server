package com.seear.comment;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("comments")
@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    @GetMapping("/{objectName}")
    public Map<String, List<Comment>> get(@PathVariable String objectName) {
        List<Comment> comments = commentRepository.findCommentsByObjectName(objectName);
        return Map.of("list", comments);
    }

    @PostMapping
    public String save(@RequestBody Map<String, String> req) {
        log.debug(req.toString());
        String objectName = req.get("objectName");
        String content = req.get("content");
        commentRepository.save(new Comment(objectName, content));
        return "Done";
    }
}
