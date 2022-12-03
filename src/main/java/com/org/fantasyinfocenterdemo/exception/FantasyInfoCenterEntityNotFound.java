package com.org.fantasyinfocenterdemo.exception;

public class FantasyInfoCenterEntityNotFound extends Exception {
    public FantasyInfoCenterEntityNotFound(String entityType, Integer id) {
        super("Entity of type " + entityType + " not found with id: " + id);
    }
}
