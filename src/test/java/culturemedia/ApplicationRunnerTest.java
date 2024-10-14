package culturemedia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationRunnerTest {

    @Test
    void run() {
        ApplicationRunner runner = new ApplicationRunner();
        runner.run();
    }
}