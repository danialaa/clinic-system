package com.example.clinicsystem.models.classes;

import com.example.clinicsystem.helpers.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class M_Schedule {
    protected int ID;
    protected String date;

    public M_Schedule(int ID, String date) {
        this.ID = ID;
        this.date = date;
    }

    public M_Schedule() {
    }

    public List<M_Schedule> getAllSchedules(String condition) {
        List<M_Schedule> schedules = new ArrayList<>();
        DatabaseConnection databaseConnection = DatabaseConnection.getINSTANCE();
        ResultSet resultSet = databaseConnection.select("schedule", condition);

        if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Schedule_ID");
                    String date = resultSet.getString("Schedule_Date");

                    M_Schedule schedule = new M_Schedule(id, date);

                    schedules.add(schedule);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return schedules;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
