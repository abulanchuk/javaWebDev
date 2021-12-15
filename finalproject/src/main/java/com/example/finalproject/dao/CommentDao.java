package com.example.finalproject.dao;

import com.example.finalproject.exception.DaoException;

public interface CommentDao {
    boolean updateComment(String newComment) throws DaoException;
}
