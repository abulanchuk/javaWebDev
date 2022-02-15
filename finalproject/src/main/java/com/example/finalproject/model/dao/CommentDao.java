package com.example.finalproject.model.dao;

import com.example.finalproject.model.entity.Comment;
import com.example.finalproject.exception.DaoException;

/**
 * The interface Comment dao.
 */
public interface CommentDao extends BaseDao<Comment> {
    /**
     * Update comment boolean.
     *
     * @param newComment the new comment
     * @param id         the id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateComment(String newComment, long id) throws DaoException;
}
