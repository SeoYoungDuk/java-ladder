package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participant;
import ladder.domain.Positions;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Locale;

public class LadderApplication {
    public static void main(String args[]) {
        List<String> participantList = InputView.getParticipant();
        List<String> resultList = InputView.getResults();
        int countOfPerson = participantList.size();

        int ladderMaxLength = InputView.getLadderMaxLength();

        ResultView.printLadderResultComment();

        Participant participant = Participant.of(participantList);
        ResultView.printParticipant(participant);

        Ladder ladder = Ladder.of(ladderMaxLength, countOfPerson);
        ResultView.drawLadder(ladder);

        Results results = Results.of(resultList);
        ResultView.printInitResults(results);

        String person = InputView.getPersonForResult();
        if (isAll(person)) {
            Positions positions = Positions.of(participant, ladder);

            Results finalResults = results.getFinalResults(positions);
            ResultView.printResultAll(participant, finalResults);
            return;
        }

        int position = participant.getParticipantPosition(person);
        int finalPosition = ladder.move(position);
        ResultView.printResult(results.getResultByPosition(finalPosition));


    }

    private static boolean isAll(String person) {
        String lowerCasePerson = person.toLowerCase(Locale.ROOT);
        return lowerCasePerson.equals("all");
    }
}
