package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.Comment;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.CommentDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class CommentDaoImpl implements CommentDao {
    static final Logger logger = LogManager.getLogger(CommentDaoImpl.class);
    private static final String SQL_SELECT_ALL_COMMENTS = """
    SELECT id_comment, content FROM comments""";
    private static final String SQL_SELECT_COMMENT_BY_ID = """
    SELECT id_comment, content FROM comments WHERE id_comment = ?""";
    private static final String SQL_DELETE_COMMENT_BY_ID = """
     DELETE FROM comments WHERE id_comment = ?""";
    private static final String SQL_INSERT_NEW_COMMENT = """
            INSERT INTO comments (id_comment, id_butler, content) VALUES (?,?,?)""";
    private static final String SQL_UPDATE_COMMENT = """
            UPDATE discounts SET content = ? WHERE id_comment = ?""";

    @Override
    public List findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Comment> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Comment user) throws DaoException {
        return false;
    }

    @Override
    public long insertNewEntity(Comment entity) throws DaoException {
        return 0;
    }


    @Override
    public boolean updateComment(String newComment) throws DaoException {
        return false;
    }
}
