package edu.epam.task4.chain;

import edu.epam.task4.composite.TextComponent;

public abstract class AbstractHandler {
    public abstract void toHandlerRequest(TextComponent component, String element);
}

