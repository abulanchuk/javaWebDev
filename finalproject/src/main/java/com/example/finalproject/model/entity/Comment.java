package com.example.finalproject.model.entity;


public class Comment extends CustomEntity{
    private long idComment;
    private long idButler;
    private String comment;

    public Comment(long idComment, long idButler, String comment) {
        this.idComment = idComment;
        this.idButler = idButler;
        this.comment = comment;
    }

    public Comment(long idButler, String comment) {
        this.idButler = idButler;
        this.comment = comment;
    }

    public Comment() {
    }

    public long getIdComment() {
        return idComment;
    }

    public long getIdButler() {
        return idButler;
    }

    public String getComment() {
        return comment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public void setIdButler(long idButler) {
        this.idButler = idButler;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comments = (Comment) o;

        if (idComment != comments.idComment) return false;
        if (idButler != comments.idButler) return false;
        return  comment.equals(comments.comment);
    }

    @Override
    public int hashCode() {
        int result = (int) (idComment ^ (idComment >>> 32));
        result = 31 * result + (int) (idButler ^ (idButler >>> 32));
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{ ");
        sb.append("idComment=").append(idComment);
        sb.append(", idButler=").append(idButler);
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
