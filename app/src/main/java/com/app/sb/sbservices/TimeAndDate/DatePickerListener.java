package com.app.sb.sbservices.TimeAndDate;

import org.joda.time.DateTime;

public interface DatePickerListener {
    void onDateSelected(DateTime dateSelected);
}