package com.map.domain;

import com.map.exceptions.ValidationException;
import com.map.util.Entity;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Assignment<ID> extends Entity<ID> {
    private String description;
    private Integer start_week;
    private Integer end_week;

    public Assignment(String description, Integer deadline) {
        LocalDate dateBefore = LocalDate.of(2019, Month.OCTOBER, 1);
        LocalDate dateAfter = LocalDate.now();
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        int week = (int) (noOfDaysBetween/7 + 1);

        this.description = description;
        this.start_week = week;
        this.end_week = deadline;
    }

    public Integer getEndWeek() {
        return end_week;
    }

    public void setEnd_week(Integer end_week) throws ValidationException {
        if ( end_week < this.start_week ) throw new ValidationException();
        this.end_week = end_week;
    }

    public Integer getStartWeek() {
        return start_week;
    }

    public void setStart_week(Integer start_week) {
        this.start_week = start_week;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
