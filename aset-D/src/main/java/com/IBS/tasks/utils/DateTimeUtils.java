package com.IBS.tasks.utils;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.List;


public class DateTimeUtils {
    public static final DateTimeFormatter DEFAULT_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final DateTimeFormatter CUSTOM_DATE_FORMAT_WITH_POINT = new DateTimeFormatterBuilder().appendPattern("dd.MM.")
            .appendValueReduced(ChronoField.YEAR, 2, 2, Year.now().getValue() - 80)
            .toFormatter();

    public static final DateTimeFormatter CUSTOM_DATE_FORMAT_WITH_SLASH = new DateTimeFormatterBuilder().appendPattern("dd/MM/")
            .appendValueReduced(ChronoField.YEAR, 2, 2, Year.now().getValue() - 80)
            .toFormatter();

    public static final List<DateTimeFormatter> SUPPORTED_DATE_FORMATS = Arrays.asList(
            CUSTOM_DATE_FORMAT_WITH_POINT,
            CUSTOM_DATE_FORMAT_WITH_SLASH,
            DateTimeFormatter.ofPattern("dd.MM.yyyy"),
            DEFAULT_DATE_FORMAT
    );

    public static LocalDate parseDateByMultipleFormats(String value) {
        for (DateTimeFormatter dateTimeFormatter : SUPPORTED_DATE_FORMATS) {
            try {
                return LocalDate.parse(value, dateTimeFormatter);
            } catch (DateTimeException e) {
                //
            }
        }
        return null;
    }
}
