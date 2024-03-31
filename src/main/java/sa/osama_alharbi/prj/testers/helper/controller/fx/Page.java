package sa.osama_alharbi.prj.testers.helper.controller.fx;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;
import sa.osama_alharbi.prj.testers.helper.service.ExtensionService;
import sa.osama_alharbi.prj.testers.helper.view.ViewGUIIndex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class Page {
    public static boolean HASE_BEAN = true;
    public static URL FXML_PATH = ViewGUIIndex.class.getResource( Page.class.getSimpleName()+".fxml");
    private final ExtensionService extensionService;

    @FXML
    public VBox root;

    private SHAFT.GUI.WebDriver driver = null;
    @FXML
    public void onStartStopBtn() throws IOException, URISyntaxException {
        if(driver != null){
            driver.quit();
            driver = null;
        }else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addExtensions(extensionService.getExtensionZip());
            driver = new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME,chromeOptions);
            driver.browser().navigateToURL("https://www.google.com/");
        }
    }
}
