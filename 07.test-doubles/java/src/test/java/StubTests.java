import org.junit.jupiter.api.Test;
import stub.Authorizer;
import stub.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StubTests {
    @Test
    void shouldDivideWhenAuthorizationIsAccepted() {
        var authorizer = mock(Authorizer.class);
        when(authorizer.authorize()).thenReturn(true);

        var calculator = new Calculator(authorizer);

        assertThat(calculator.divide(9, 3)).isEqualTo(3);
    }

    @Test
    void shouldThrowWhenAuthorizationIsDenied() {

        var authorizer = mock(Authorizer.class);
        when(authorizer.authorize()).thenReturn(false);

        var calculator = new Calculator(authorizer);

        assertThatThrownBy(() -> calculator.divide(9, 3))
                .isInstanceOf(SecurityException.class);
    }
}
