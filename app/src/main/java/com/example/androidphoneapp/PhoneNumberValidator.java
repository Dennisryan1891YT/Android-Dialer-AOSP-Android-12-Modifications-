package com.example.androidphoneapp;

import java.util.Arrays;
import java.util.List;

public class PhoneNumberValidator {

    private static final List<String> BLOCKED_EMERGENCY_NUMBERS = Arrays.asList(
            "911", "999", "112", "110", "000"
    );

    public static boolean isEmergencyNumber(String rawInput) {
        if (rawInput == null) return false;

        String digits = rawInput.replaceAll("[^0-9]", "");

        if (digits.isEmpty()) return false;

        for (String blocked : BLOCKED_EMERGENCY_NUMBERS) {
            if (digits.equals(blocked)) {
                return true;
            }
        }

        for (String blocked : BLOCKED_EMERGENCY_NUMBERS) {
            if (digits.endsWith(blocked)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidCustomPhoneNumber(String rawInput) {
        if (rawInput == null) return false;

        String digits = rawInput.replaceAll("[^0-9]", "");

        if (digits.length() < 1 || digits.length() > 10000) {
            return false;
        }

        if (isEmergencyNumber(digits)) {
            return false;
        }

        return true;
    }
}
