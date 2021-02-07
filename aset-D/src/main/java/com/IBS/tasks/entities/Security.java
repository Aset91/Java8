package com.IBS.tasks.entities;

import com.IBS.tasks.utils.DateTimeUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Security {
    private String securityName;
    private String code;
    private LocalDate validTill;
    private String ownerName;

    public Security() {

    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValidTill() {
        return validTill.format(DateTimeUtils.DEFAULT_DATE_FORMAT);
    }

    public LocalDate getValidTillAsDate() {
        return validTill;
    }

    public void setValidTill(String validTill) {
        this.validTill = LocalDate.parse(validTill, DateTimeUtils.DEFAULT_DATE_FORMAT);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "securityName = \"" + securityName +
                "\", code = \"" + code +
                "\", validTill = \"" + validTill +
                "\", ownerName = \"" + ownerName+ "\"";
    }
}
