package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.comment.CommentRequest;
import com.ugurukku.kitabal.dto.comment.CommentResponse;
import com.ugurukku.kitabal.dto.mapper.CommentMapper;
import com.ugurukku.kitabal.entities.Comment;
import com.ugurukku.kitabal.entities.User;
import com.ugurukku.kitabal.repositories.CommentRepository;
import com.ugurukku.kitabal.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public List<CommentResponse> getAllByBookId(Long bookId) {
        return mapper.toCommentResponse(repository.findAllByBookId(bookId));
    }

    @Override
    public void add(CommentRequest commentRequest,Long userId) {
        Comment comment = mapper.toEntity(commentRequest);
        comment.setId(sequenceGenerator.generateSequence(Comment.SEQUENCE_NAME));
        comment.setUser(User.builder().id(userId).build());
        repository.save(comment);
    }
}
