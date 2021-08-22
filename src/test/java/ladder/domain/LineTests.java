package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTests {
    @DisplayName("생성 테스트")
    @Test
    void create() {
        List<Point> points = Arrays.asList(Point.first(true));

        Line line = Line.of(points);

        assertThat(line).isEqualTo(Line.of(Arrays.asList(Point.first(true))));
    }

    @DisplayName("Line move 시 왼쪽 제대로 움직이는지 테스트")
    @Test
    void moveLeftTest() {
        int position = 1;
        List<Point> points = Arrays.asList(Point.first(true), Point.first(true).next(false), Point.first(true).next(false).last());

        Line line = Line.of(points);

        assertThat(line.movedPosition(position)).isEqualTo(0);
    }

    @DisplayName("Line move 시 오른쪽 제대로 움직이는지 테스트")
    @Test
    void moveRightTest() {
        int position = 1;
        List<Point> points = Arrays.asList(Point.first(false), Point.first(false).next(true), Point.first(false).next(true).last());

        Line line = Line.of(points);

        assertThat(line.movedPosition(position)).isEqualTo(2);
    }

    @DisplayName("그리는 상황 인 지 테스트")
    @Test
    void draw() {
        List<Point> points = Arrays.asList(Point.first(false), Point.first(false).next(true), Point.first(false).next(true).last());

        Line line = Line.of(points);

        assertThat(line.isDraw(0)).isEqualTo(false);
        assertThat(line.isDraw(1)).isEqualTo(false);
        assertThat(line.isDraw(2)).isEqualTo(true);
    }
}
