package sa.osama_alharbi.prj.testers.helper.controller.fx;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;
import sa.osama_alharbi.prj.testers.helper.service.fx.GUI;
import sa.osama_alharbi.prj.testers.helper.view.ViewGUIIndex;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class Root {
    public static boolean HASE_BEAN = false;
    public static URL FXML_PATH = ViewGUIIndex.class.getResource( Root.class.getSimpleName()+".fxml");
    @FXML
    public BorderPane root;
}
