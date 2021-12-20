package com.example.finalproject.model.dao;

import com.example.finalproject.exception.DaoException;

public interface CommentDao {
    boolean updateComment(String newComment) throws DaoException;
}
