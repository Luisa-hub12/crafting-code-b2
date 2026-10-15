import mock.Client;
import mock.Notifier;
import mock.ScenarioReceived;
import mock.ScenarioReceivedEventHandler;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.mockito.Mockito.*;

class MockTests {
    @Test
    void shouldNotifyAllClientsWhenScenarioIsReceived() {
        var clients = List.of(
                new Client("Cliff Booth", "cliff.booth@double.com"),
                new Client("Rick Dalton", "rick.dalton@double.com")
        );

        var mockNotifier = mock(Notifier.class);
        var handler = new ScenarioReceivedEventHandler(mockNotifier, clients);
        var event = new ScenarioReceived("The 14 fists of McCluskey");

        handler.handle(event);

        clients.forEach(client -> verify(mockNotifier, times(1))
                .notify(client, event));
    }
}
