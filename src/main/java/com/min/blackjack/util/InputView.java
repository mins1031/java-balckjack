package com.min.blackjack.util;

import com.min.blackjack.validator.DrawCardValidation;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputParticipantNames() {
        return scanner.nextLine();
    }

    public static String inputDrawCardYesOrNo(String participantName) {
        System.out.println(participantName + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String inputYesOrNo = scanner.next();
        DrawCardValidation.drawCardValidation(inputYesOrNo);
        return inputYesOrNo;
    }
}
