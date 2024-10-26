package com.tutget.main.model;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "listings")
public class Listing {

    @Id
    private String id;

    private String acadLvl;
    private String acadSubject;
    private String postalCode;
    private Date postDate;
    private String dayOfWeek;
    private int frequency;
    private Date startDate;
    private int hourlyRate;
    private String description;
    private int[] selectedHour;
    private int[] selectedMin;
    private String selectedHourNum;
    private int computedTotal;

    private String userId;
    private String status;
    private String requests;

    private String assignedTutorId;

    public Listing() {}

    public Listing(String acadLvl, String acadSubject, String postalCode, Date postDate, String dayOfWeek, int frequency, Date startDate, int hourlyRate, String description, int[] selectedHour, int[] selectedMin, String selectedHourNum, String userId, String status, String requests, String assignedTutorId, int computedTotal) {
        this.acadLvl = acadLvl;
        this.acadSubject = acadSubject;
        this.postalCode = postalCode;
        this.postDate = postDate;
        this.dayOfWeek = dayOfWeek;
        this.frequency = frequency;
        this.startDate = startDate;
        this.hourlyRate = hourlyRate;
        this.description = description;
        this.selectedHour = selectedHour;
        this.selectedMin = selectedMin;
        this.selectedHourNum = selectedHourNum;
        this.userId = userId;
        this.status = status;
        this.requests = requests;
        this.assignedTutorId = assignedTutorId;
        this.computedTotal = computedTotal;
    }

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

    public int getComputedTotal() {
        return computedTotal;
    }

    public void setComputedTotal(int computedTotal) {
        this.computedTotal = computedTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcadLvl() {
        return acadLvl;
    }

    public void setAcadLvl(String acadLvl) {
        this.acadLvl = acadLvl;
    }

    public String getAcadSubject() {
        return acadSubject;
    }

    public void setAcadSubject(String acadSubject) {
        this.acadSubject = acadSubject;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getSelectedHour() {
        return selectedHour;
    }

    public void setSelectedHour(int[] selectedHour) {
        this.selectedHour = selectedHour;
    }

    public int[] getSelectedMin() {
        return selectedMin;
    }

    public void setSelectedMin(int[] selectedMin) {
        this.selectedMin = selectedMin;
    }

    public String getSelectedHourNum() {
        return selectedHourNum;
    }

    public void setSelectedHourNum(String selectedHourNum) {
        this.selectedHourNum = selectedHourNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequests() {
        return requests;
    }

    public void setRequests(String requests) {
        this.requests = requests;
    }

    public String getAssignedTutorId() {
        return assignedTutorId;
    }

    public void setAssignedTutorId(String assignedTutorId) {
        this.assignedTutorId = assignedTutorId;
    }
}
