package com.map.domain;

import com.map.exceptions.ValidationException;
import com.map.util.Entity;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Assignment<ID> extends Entity<ID> {
    private String description;
    private Integer startWeek;
    private Integer endWeek;

    public Assignment(String description, Integer deadline) {
        LocalDate dateBefore = LocalDate.of(2019, Month.OCTOBER, 1);
        LocalDate dateAfter = LocalDate.now();
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        int week = (int) (noOfDaysBetween/7 + 1);

        this.description = description;
        this.startWeek = week;
        this.endWeek = deadline;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public Assignment setEndWeek(Integer end_week) throws ValidationException {
        if ( end_week < this.startWeek ) {
            throw new ValidationException();
        }
        this.endWeek = end_week;
        return this;
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public Assignment setStartWeek(Integer start_week) {
        this.startWeek = start_week;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Assignment setDescription(String description) {
        this.description = description;
        return this;
    }
}
