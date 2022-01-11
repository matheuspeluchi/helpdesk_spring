package com.mpr.helpdesk.application.common.exceptions;

import java.io.Serializable;

public class Error implements Serializable {

    private static final long serialVersionUID = -9185560773094131109L;

    private String source;
    private String detail;


    public Error() {
        super();
    }

    public Error(String detail, String source) {
        super();
        this.source = source;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
