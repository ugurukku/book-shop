package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.CommentRequest;
import com.ugurukku.kitabal.dto.book.CommentResponse;
import com.ugurukku.kitabal.entities.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentResponse toCommentResponse(Comment comment);

    List<CommentResponse> toCommentResponse(List<Comment> comments);

    Comment toEntity(CommentRequest commentRequest);

}
