package nextstep.ladder.Model;

import nextstep.ladder.Strategy.ConnectBridgeStrategy;
import nextstep.ladder.Strategy.RandomConnectBrideStragegy;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    public Ladder generateLadder(int peopleCount, Height height) {
        List<Line> ladder = new ArrayList<>();
        int ladderHeight = height.getHeight();
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(createLine(peopleCount));
        }
        return new Ladder(ladder);
    }

    private Line createLine(int peopleCount) {
        Line line = new Line(new ArrayList<>());
        ConnectBridgeStrategy connectBridgeStrategy = new RandomConnectBrideStragegy();
        for (int i = 0; i < peopleCount; i++) {
            line.checkThisPointIsAbleConnectAndExecuteConnect(connectBridgeStrategy);
        }
        return line;
    }

}
