package nextstep.ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    private static final int START_LOCATION = 1;
    private static final int LEFT_EXPECT_LOCATION = 0;
    private static final int RIGHT_EXPECT_LOCATION = 2;

    @Test
    @DisplayName("Line을 생성한 이후에 true만을 삽입하여 원하는 결과가 나오는지에 대한 테스트")
    public void connectBridgeTrueTest() {
        Line line = new Line(new ArrayList<>());
        List<Bridge> expectLine = new ArrayList<>();
        line.checkDecidingConnectBridge(() -> true);
        line.checkDecidingConnectBridge(() -> true);
        line.checkDecidingConnectBridge(() -> true);
        expectLine.add(new Bridge(false));
        expectLine.add(new Bridge(true));
        expectLine.add(new Bridge(false));
        assertThat(line.getLine()).isEqualTo(expectLine);
    }

    @Test
    @DisplayName("Line을 생성한 이후에 false값만 삽입하여 원하는 결과가 나오는지에 대한 테스트")
    public void connectBridgeFalseTest() {
        Line line = new Line(new ArrayList<>());
        List<Bridge> expectLine = new ArrayList<>();
        line.checkDecidingConnectBridge(() -> false);
        line.checkDecidingConnectBridge(() -> false);
        line.checkDecidingConnectBridge(() -> false);
        expectLine.add(new Bridge(false));
        expectLine.add(new Bridge(false));
        expectLine.add(new Bridge(false));
        assertThat(line.getLine()).isEqualTo(expectLine);
    }

    @Test
    @DisplayName("Line을 생성한 이후에 move메소드가 왼쪽으로 정상적으로 작동 되는지에 대한 테스트")
    public void lineLeftMoveTest(){
        Line line = new Line(new ArrayList<>());
        line.checkDecidingConnectBridge(() ->false);
        line.checkDecidingConnectBridge(() ->true);
        line.checkDecidingConnectBridge(() ->false);
        assertThat(line.move(START_LOCATION)).isEqualTo(LEFT_EXPECT_LOCATION);
    }

    @Test
    @DisplayName("Line을 생성한 이후에 move메소드가 오른쪽으로 정상적으로 작동 되는지에 대한 테스트")
    public void lineRightMoveTest(){
        Line line = new Line(new ArrayList<>());
        line.checkDecidingConnectBridge(() ->false);
        line.checkDecidingConnectBridge(() ->false);
        line.checkDecidingConnectBridge(() ->true);
        assertThat(line.move(START_LOCATION)).isEqualTo(RIGHT_EXPECT_LOCATION);
    }

}