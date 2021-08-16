package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participant;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String args[]) {
        List<String> participant = InputView.getParticipant();
        int countOfPerson = participant.size();

        int ladderMaxLength = InputView.getLadderMaxLength();

        ResultView.printResultComment();
        ResultView.printParticipant(Participant.of(participant));
        ResultView.drawLadder(Ladder.of(ladderMaxLength, countOfPerson));


    }
}
