package com.example.finalproject.model.dao.impl;

import com.example.finalproject.model.entity.Comment;
import com.example.finalproject.exception.DaoException;
import com.example.finalproject.model.dao.CommentDao;
import com.example.finalproject.model.entity.CustomEntity;
import com.example.finalproject.model.mapper.impl.CommentCreator;
import com.example.finalproject.model.pool.ConnectionPool;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentDaoImpl implements CommentDao {
    private static final Logger logger = LogManager.getLogger(CommentDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_SELECT_ALL_COMMENTS = "SELECT id_comment, content FROM comments";
    private static final String SQL_SELECT_COMMENT_BY_ID = "SELECT id_comment, content FROM comments WHERE id_comment = ?";
    private static final String SQL_DELETE_COMMENT_BY_ID = "DELETE FROM comments WHERE id_comment = ?";
    private static final String SQL_INSERT_NEW_COMMENT = "INSERT INTO comments (id_butler, content) VALUES (?,?)";
    private static final String SQL_UPDATE_COMMENT = "UPDATE comments SET content = ? WHERE id_comment = ?";
    private CommentCreator commentCreator = new CommentCreator();

    @Override
    public List findAll() throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_COMMENTS)) {
            List<Comment> comments = new ArrayList<>();
            while (resultSet.next()) {
                Comment comment = commentCreator.create(resultSet);
                comments.add(comment);
            }
            logger.log(Level.DEBUG, "findAll method from CommentDaoImpl was completed successfully. " + comments.size() + " were found");
            return comments;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find comments. Database access error:", e);
            throw new DaoException("Impossible to find comments. Database access error:", e);
        }
    }

    @Override
    public Optional<Comment> findById(Long id) throws DaoException {
        Optional<Comment> commentOptional = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_COMMENT_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Comment comment = commentCreator.create(resultSet);
                    commentOptional = Optional.of(comment);
                }
            }
            logger.log(Level.DEBUG, "findById method from CommentDaoImpl was completed successfully."
                    + ((commentOptional.isPresent()) ? " Comment with id " + id + " was found" : " Comment with id " + id + " don't exist"));
            return commentOptional;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to find comment by id. Database access error:", e);
            throw new DaoException("Impossible to find comment by id. Database access error:", e);
        }
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COMMENT_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to delete comment with such id: " + id, e);
            throw new DaoException("Impossible to delete comment with such id: " + id, e);
        }
    }

    @Override
    public Comment insertNewEntity(CustomEntity entity) throws DaoException {
        if (!(entity instanceof Comment)) {
            logger.log(Level.ERROR, "Expected type Comment, got " + entity.getClass());
            throw new DaoException("Expected type Comment, got " + entity.getClass());
        }
        Comment comment = (Comment) entity;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_NEW_COMMENT)) {

            statement.setLong(1, comment.getIdButler());
            statement.setString(2, comment.getComment());
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.DEBUG, "Failed to create comment", e);
            throw new DaoException("Failed to create comment: ", e);
        }
        return comment;
    }


    @Override
    public boolean updateComment(String newComment, long id) throws DaoException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_COMMENT)) {
            statement.setString(1, newComment);
            statement.setLong(2, id);
            boolean isUpdated = statement.executeUpdate() == 1;
            if (!isUpdated) {
                logger.log(Level.INFO, "Comment didn't update with id " + id);
                return false;
            }
            logger.log(Level.DEBUG, "Result of update comment with id " + id + " is " + newComment);
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Impossible to update comment. Database access error:", e);
            throw new DaoException("Impossible to update comment. Database access error:", e);
        }
    }
}
