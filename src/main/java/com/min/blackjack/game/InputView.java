package com.min.blackjack.game;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputParticipantNames() {
        return scanner.next();
    }
}
