package com.denisabramov.postings.service;

import com.denisabramov.postings.dao.entity.Posting;
import com.denisabramov.postings.dao.entity.User;
import com.denisabramov.postings.dao.repository.PostingRepository;
import com.denisabramov.postings.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class PostingService {
    private final CsvReader reader;
    private final UserRepository userRepository;
    private final PostingRepository postingRepository;

    public PostingService(CsvReader reader, UserRepository userRepository, PostingRepository postingRepository) {
        this.reader = reader;
        this.userRepository = userRepository;
        this.postingRepository = postingRepository;
    }

    public void init() throws FileNotFoundException {
        var users = reader.readLogins();
        var postings = reader.readPostings();
        postings.forEach(posting -> {
            var authorizedUser = users.stream()
                    .filter(user -> user.getUsername().equals(posting.getUsername()))
                    .filter(User::isActive)
                    .findFirst();
            if (authorizedUser.isPresent())
                posting.setAuthorized(true);
        });
        userRepository.saveAll(users);
        postingRepository.saveAll(postings);
    }

    public List<Posting> getAllPostings(boolean authorizedOnly){
        if (authorizedOnly){
            return postingRepository.findAllByIsAuthorized(true);
        }
        return postingRepository.findAll();
    }

}
