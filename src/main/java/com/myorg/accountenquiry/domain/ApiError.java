package com.myorg.accountenquiry.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {
    private String message;
    private String errorCode;
    private String severity;
    private String location;
}
