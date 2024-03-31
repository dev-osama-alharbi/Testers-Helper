package sa.osama_alharbi.prj.testers.helper.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@Slf4j
public class ExtensionService{

    public File getExtensionZip(){
        File dir = new File("extension/");
        File dirZip = new File("extension/zip/");
        File extensionFile = new File("extension/zip/extension.zip");
        if(!dir.exists()){
            dir.mkdirs();
        }
        if(!dirZip.exists()){
            dirZip.mkdirs();
        }
        if(extensionFile.exists()){
            try {
                FileUtils.delete(extensionFile);
            } catch (IOException e) {
                try {
                    FileUtils.forceDelete(extensionFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        File extensionDir = new File("src/main/resources/static/extension");
        String[] extensionFiles = extensionDir.list();
        ArrayList<String> listExtensionFile = new ArrayList<>();
        for (String f : extensionFiles) {
            listExtensionFile.add("src/main/resources/static/extension/"+f);
        }
        compressMultipleFiles(extensionFile, listExtensionFile);

        return extensionFile;
    }

    private void compressMultipleFiles(File outputZip, List<String> srcFiles){
        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        try {
            fos = new FileOutputStream(outputZip);
            zipOut = new ZipOutputStream(fos);

            for (String srcFile : srcFiles) {
                File fileToZip = new File(srcFile);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(zipOut != null){
                    zipOut.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
