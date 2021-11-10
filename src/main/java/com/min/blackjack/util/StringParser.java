package com.min.blackjack.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static final String parseStandard = ",";

    public static List<String> parseParticipantName(String inputParticipantNames) {
        return Arrays.asList(inputParticipantNames.split(parseStandard));
    }
}
