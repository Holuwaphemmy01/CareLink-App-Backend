package com.app.CareLink.regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateOfBirthValidator {
    public static boolean isValidDateOfBirth(LocalDate dateOfBirth) {
//        String regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[01])$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(dateOfBirth);
//        return matcher.matches();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = dateOfBirth.format(formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
