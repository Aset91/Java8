package com.IBS.tasks.entities;

import com.IBS.tasks.utils.DateTimeUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Organization {
    private String name;
    private String address;
    private long phoneNumber;
    private long inn;
    private long ogrn;
    private LocalDate foundationDate;
    private List<Security> securities;

    public Organization() {
        securities = new ArrayList<Security>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public long getOgrn() {
        return ogrn;
    }

    public void setOgrn(long ogrn) {
        this.ogrn = ogrn;
    }

    public void setFoundationDate(String date) {
        this.foundationDate = LocalDate.parse(date, DateTimeUtils.DEFAULT_DATE_FORMAT);
    }

    public String getFoundationDate() {
        return foundationDate.format(DateTimeUtils.DEFAULT_DATE_FORMAT);
    }

    public LocalDate getFoundationDateAsDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    @Override
    public String toString() {
        return "[name=\"" + name +
                "\", address=\"" + address +
                "\", phoneNumber=\"" + phoneNumber +
                "\", inn=\"" + inn +
                "\", ogrn=\"" + ogrn +
                "\", foundationDate=\"" + foundationDate +
                "\", securities=\"" + securities + "\"]";
    }
}
