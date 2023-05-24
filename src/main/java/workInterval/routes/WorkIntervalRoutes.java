package workInterval.routes;

import workInterval.controllers.InsertWorkIntervalsController;
import workInterval.dtos.NewWorkIntervalDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WorkIntervalRoutes {

    @PostMapping(path = "/workInterval", 
                consumes = MediaType.APPLICATION_JSON_VALUE, 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> insertWorkInterval(@RequestBody NewWorkIntervalDto newWorkInterval) {
        return InsertWorkIntervalsController.execute(newWorkInterval);
    }

}
