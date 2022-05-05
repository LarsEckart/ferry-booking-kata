
import ferry.booking.Program;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class GoldenMasterTests {

    @Test
    public void golden_master() throws Exception {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final String utf8 = StandardCharsets.UTF_8.name();
        try (PrintStream ps = new PrintStream(baos, true, utf8)) {
            Program.mainWithTestData(ps);
        }
        Approvals.verify(baos.toString(utf8));
    }
}
