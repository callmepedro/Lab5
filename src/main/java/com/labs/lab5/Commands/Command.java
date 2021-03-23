package com.labs.lab5.Commands;

/**
 * interface for pattern 'Command'
 */
public interface Command {
    boolean execute();
    String getName();
    String getDescription();
}
