package sa.osama_alharbi.prj.testers.helper.service.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class CompressService {

    public File compressFiles(List<File> files){
        File dir = new File("extension");
        File extensionFile = new File("extension/extension.zip");
        if(!dir.exists()){
            try {
                FileUtils.forceMkdir(dir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(extensionFile.exists()){
            try {
                FileUtils.delete(extensionFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return extensionFile;
    }
}
