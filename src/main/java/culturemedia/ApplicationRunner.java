package culturemedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationRunner {
    protected static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    void run() {
        logger.info("La aplicación ha sido ejecutada exitosamente.");
    }

}
