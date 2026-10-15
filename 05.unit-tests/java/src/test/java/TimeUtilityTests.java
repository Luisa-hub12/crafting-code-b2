import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import unit.tests.intro.Clock;
import unit.tests.intro.TimeUtility;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TimeUtilityTests {
    private Clock clockMock;
    private TimeUtility timeUtility;

    public static Stream<Arguments> timeTestCases() {
        return Stream.of(
                Arguments.of(0,"Night"),
                Arguments.of(5,"Night"),
                Arguments.of(10,"Morning"),
                Arguments.of(16,"Afternoon"),
                Arguments.of(22,"Evening"),
                Arguments.of(12, "Afternoon"),
                Arguments.of(17, "Afternoon"),
                Arguments.of(18, "Evening"),
                Arguments.of(23, "Evening")
                );
    }

    @BeforeEach
    void setUp() {
        clockMock = mock(Clock.class);
        timeUtility = new TimeUtility(clockMock);
    }
    @ParameterizedTest
    @MethodSource("timeTestCases")
    void time(int hour, String expectedResult) {
        when(clockMock.now()).thenReturn(LocalTime.of(hour, 0));
        assertThat(timeUtility.getTimeOfDay()).isEqualTo(expectedResult);
    }
}
