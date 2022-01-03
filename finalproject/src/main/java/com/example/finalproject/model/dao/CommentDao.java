package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Comment;
import com.example.finalproject.exception.DaoException;

public interface CommentDao extends BaseDao<Comment> {
    boolean updateComment(String newComment, long id) throws DaoException;
}
