package com.example.finalproject.controller.command;

import com.example.finalproject.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public interface Command {
    Router execute(HttpServletRequest request);
}
