package com.myorg.accountenquiry.exception;

import com.myorg.accountenquiry.domain.ApiError;
import lombok.Getter;

@Getter
public class ApiGeneralException extends RuntimeException {

    private ApiError apiError;

    public ApiGeneralException(ApiError apiError) {
        this.apiError = apiError;
    }
}
