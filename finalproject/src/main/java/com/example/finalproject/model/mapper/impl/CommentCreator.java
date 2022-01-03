package com.example.finalproject.model.mapper.impl;

import com.example.finalproject.model.entity.Comment;
import com.example.finalproject.model.mapper.RowCreator;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.finalproject.model.mapper.ColumnTableName.*;

public class CommentCreator implements RowCreator {
    public CommentCreator() {
    }

    @Override
    public Comment create(ResultSet resultSet) throws SQLException {
        Comment comment = new Comment();
        comment.setIdComment(resultSet.getLong(COMMENTS_ID_COMMENT));
        comment.setIdButler(resultSet.getLong(COMMENTS_ID_BUTLER));
        comment.setComment(resultSet.getString(COMMENTS_CONTENT));
        return comment;
    }
}
