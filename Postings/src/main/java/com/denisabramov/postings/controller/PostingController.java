package com.denisabramov.postings.controller;

import com.denisabramov.postings.dao.entity.Posting;
import com.denisabramov.postings.service.PostingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostingController {
    private final PostingService postingService;

    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @GetMapping
    public List<Posting> getPostings(@RequestParam(required = false) boolean authorizedOnly){
        return postingService.getAllPostings(authorizedOnly);
    }
}
