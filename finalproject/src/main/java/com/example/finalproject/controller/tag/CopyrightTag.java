package com.example.finalproject.controller.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspTagException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class CopyrightTag extends TagSupport {
    @Override
    public int doStartTag() throws JspTagException {
        try{
            JspWriter out = pageContext.getOut();
            String tagText = "<p class=\"footer\">© 2022 Copyright: Fushifaru.com</p>";
            out.write(tagText);
        } catch (IOException e) {
            throw new JspTagException(e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
