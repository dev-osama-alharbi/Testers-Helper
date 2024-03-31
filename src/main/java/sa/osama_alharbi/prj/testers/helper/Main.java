package sa.osama_alharbi.prj.testers.helper;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sa.osama_alharbi.prj.testers.helper.config.springFx.JavaFxLauncher;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //test
        Application.launch(JavaFxLauncher.class,args);
    }
}