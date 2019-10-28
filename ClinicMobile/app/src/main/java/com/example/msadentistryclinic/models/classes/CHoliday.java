package com.example.msadentistryclinic.models.classes;

public class CHoliday extends CSchedule {
    private String endDate, holidayName;
    private int duration;

    public CHoliday(int ID, String date, String endDate, String holidayName, int duration) {
        super(ID, date);
        this.endDate = endDate;
        this.holidayName = holidayName;
        this.duration = duration;
    }

    public CHoliday() {
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
