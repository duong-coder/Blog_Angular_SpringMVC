package com.dependency.inject.stack.common;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.TimeZone;

import com.dependency.inject.stack.service.dto.PasswordGenerator;

/**
 * The type String utils.
 */
public class StringUtils {

    /**
     * utf 8 encoding value
     */
    public static final String ENCODING_UTF_8 = "UTF-8";

    /**
     * Generate passay password string.
     *
     * @return the string
     */
    public static String generatePassayPassword() {
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();

        return passwordGenerator.generate(8); // output ex.: lrU12fmM 75iwI90o
    }

    /**
     * compare date of day between two day
     *
     * @param instant   :  the Day wanner compare
     * @param compareTo : the Day was compare
     * @return boolean if eq then return true, opposite will return false
     */
    public static boolean isAfterBasedOnDate(Instant instant, Instant compareTo) {
        return instant.truncatedTo(ChronoUnit.DAYS).equals(compareTo.truncatedTo(ChronoUnit.DAYS));
    }

    /**
     * Is before today boolean.
     *
     * @param instant the instant
     * @return the boolean
     */
    public static boolean isBeforeToday(Instant instant) {
        TimeZone zone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
        Instant instantNow = Calendar.getInstance(zone).getTime().toInstant().plus(7, ChronoUnit.HOURS);

        return instant.truncatedTo(ChronoUnit.DAYS).isBefore(instantNow.truncatedTo(ChronoUnit.DAYS));
    }

}
