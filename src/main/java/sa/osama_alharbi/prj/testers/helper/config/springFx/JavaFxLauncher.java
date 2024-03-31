package sa.osama_alharbi.prj.testers.helper.config.springFx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import sa.osama_alharbi.prj.testers.helper.Main;

public class JavaFxLauncher extends Application {
    public static ConfigurableApplicationContext springContext;

    @Override
    public void start(Stage stage) throws Exception {
        springContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(Main.class).run();
    }

    @Override
    public void stop() {
        springContext.close();
        Platform.exit();
    }
}
