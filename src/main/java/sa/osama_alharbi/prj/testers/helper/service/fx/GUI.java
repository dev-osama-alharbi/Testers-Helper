package sa.osama_alharbi.prj.testers.helper.service.fx;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sa.osama_alharbi.prj.testers.helper.config.springFx.JavaFxLauncher;
import sa.osama_alharbi.prj.testers.helper.controller.fx.Page;
import sa.osama_alharbi.prj.testers.helper.controller.fx.Root;
import sa.osama_alharbi.prj.testers.helper.view.ViewGUIIndex;

import java.io.IOException;
import java.net.URL;

@RequiredArgsConstructor
@Service
public class GUI {
    public Stage stage;
    public Scene scene;

    private final ControllerGUI controller;
    private final ViewGUI view;

    public void start(Stage stage) {
        this.stage = stage;
        generateGUI();
    }

    private void generateGUI() {

        FXMLLoader loaderPage = getLoader(Page.FXML_PATH,Page.HASE_BEAN);
        view.gui_Page = (VBox) getPain(loaderPage);
        controller.page = loaderPage.<Page>getController();

        FXMLLoader loaderRoot = getLoader(Root.FXML_PATH,Root.HASE_BEAN);
        view.gui_Root = (BorderPane) getPain(loaderRoot);
        controller.root = loaderRoot.<Root>getController();
        view.gui_Root.setCenter(view.gui_Page);

        scene = new Scene(view.gui_Root);
        scene.getStylesheets().add(ViewGUIIndex.class.getResource("css.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

        Platform.setImplicitExit(true);
    }

    public FXMLLoader getLoader(String path, boolean hasBean) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewGUIIndex.class.getResource(path + ".fxml"));
        if(hasBean){
            loader.setControllerFactory(JavaFxLauncher.springContext::getBean);
        }
        return loader;
    }

    public FXMLLoader getLoader(URL url, boolean hasBean) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        if(hasBean){
            loader.setControllerFactory(JavaFxLauncher.springContext::getBean);
        }
        return loader;
    }

    public Pane getPain(FXMLLoader loader) {
        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
