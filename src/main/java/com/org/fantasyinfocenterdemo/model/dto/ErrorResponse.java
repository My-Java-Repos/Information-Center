package com.org.fantasyinfocenterdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 4250595582501466154L;

    private LocalDate timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
