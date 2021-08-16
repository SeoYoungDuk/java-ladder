package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_PARTICIPANT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GET_LADDER_MAX_LENGTH_QUESTION = "최대 사다리 높이는 몇 개인가요?";

    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String SPLIT_CUSTOM_REGEX = ",|, | ,";


    public static List<String> getParticipant() {
        System.out.println(GET_PARTICIPANT_QUESTION);
        String participantString = scanner.nextLine();
        String trimParticipant = participantString.replace(SPACE, BLANK);
        return makeParticipant(trimParticipant);
    }

    private static List<String> makeParticipant(String trimParticipant) {
        return Arrays.asList(trimParticipant.split(SPLIT_CUSTOM_REGEX));
    }

    public static int getLadderMaxLength() {
        System.out.println(GET_LADDER_MAX_LENGTH_QUESTION);
        return scanner.nextInt();
    }
}
