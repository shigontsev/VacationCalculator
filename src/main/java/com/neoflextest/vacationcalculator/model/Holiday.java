package com.neoflextest.vacationcalculator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Holiday {
    private List<LocalDate> dateList;
    public Holiday()
    {
        dateList = new ArrayList<>();
    }

    public Holiday(List<LocalDate> new_dateList)
    {
        dateList = new_dateList;
    }

    public void add(LocalDate new_day)
    {
        if (!dateList.contains(new_day))
            dateList.add(new_day);
    }

    public void remove(LocalDate day)
    {
        dateList.remove(day);
    }

    public boolean isContains(LocalDate day)
    {
        return dateList.contains(day);
    }
}
