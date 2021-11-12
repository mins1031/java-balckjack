package com.min.blackjack.util;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputParticipantNames() {
        return scanner.next();
    }
}
