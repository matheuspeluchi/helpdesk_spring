package com.mpr.helpdesk.application.common.exceptions;

public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = -3167050429202038797L;
    private String source;
    private String detail;

    public NotFoundException(String error, Throwable cause) {
        super(error, cause);
    }

    public NotFoundException(String error) {
        super(error);
    }

    public NotFoundException(String detail, String source){
        super();
        this.source = source;
        this.detail = "O recurso com o parâmetro " + detail + " não foi localizado!";;

    }

    public String getSource() {
        return source;
    }

    public String getDetail() {
        return detail;
    }
}
