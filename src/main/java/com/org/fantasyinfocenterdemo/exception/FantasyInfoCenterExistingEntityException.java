package com.org.fantasyinfocenterdemo.exception;

public class FantasyInfoCenterExistingEntityException extends Exception {

    public FantasyInfoCenterExistingEntityException(String entityName, Integer existingId) {
        super("Another record of type " + entityName + " already exists. (Id == " + existingId + ").");
    }
}
