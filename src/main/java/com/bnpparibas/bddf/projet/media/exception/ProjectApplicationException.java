package com.bnpparibas.bddf.projet.media.exception;

import java.util.HashSet;
import java.util.Set;

public class ProjectApplicationException extends RuntimeException {
    private Set<String> errorCodes = new HashSet<>();

    public ProjectApplicationException(Set<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    public ProjectApplicationException(String errorCode) {
        this.errorCodes.add(errorCode);
    }

    public Set<String> getErrorCodes() {
        return errorCodes;
    }
}
