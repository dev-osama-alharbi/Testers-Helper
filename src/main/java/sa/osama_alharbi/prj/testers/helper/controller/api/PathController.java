package sa.osama_alharbi.prj.testers.helper.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.osama_alharbi.prj.testers.helper.dto.NewPathDto;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/path")
@Slf4j
public class PathController {

    // http://localhost:5551/swagger-ui/index.html     == PostMan
    // http://localhost:5551/api/v1/path

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<Boolean> downloadExtension(@RequestBody NewPathDto newPathDto){
        System.out.println("NewPathDto => "+newPathDto.getFullXPath());
        return ResponseEntity.ok(true);
    }
}
