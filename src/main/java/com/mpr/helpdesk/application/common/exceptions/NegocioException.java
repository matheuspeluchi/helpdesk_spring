package com.mpr.helpdesk.application.common.exceptions;

public class NegocioException extends RuntimeException{

    private static final long serialVersionUID = -1114381211811799210L;
    private String source;
    private String detail;

    public NegocioException(String error, Throwable cause) {
        super(error.toString(), cause);
    }

    public NegocioException(String error) {
        super(error);
    }

    public NegocioException(String detail, String source){
        super();
        this.source = source;
        this.detail = detail;

    }

    public String getSource() {
        return source;
    }

    public String getDetail() {
        return detail;
    }
}
