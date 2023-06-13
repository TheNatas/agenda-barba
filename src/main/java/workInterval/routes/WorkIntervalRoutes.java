package workInterval.routes;

import org.springframework.web.bind.annotation.*;
import workInterval.controllers.DeleteWorkIntervalsController;
import workInterval.controllers.GetWorkIntervalsByBarberShopController;
import workInterval.controllers.InsertWorkIntervalsController;
import workInterval.controllers.UpdateWorkIntervalsController;
import workInterval.dtos.MinWorkIntervalDto;
import workInterval.dtos.FullWorkIntervalDto;
import workInterval.dtos.NewWorkIntervalDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import workInterval.dtos.WorkIntervalDto;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkIntervalRoutes {

    @PostMapping(path = "/workInterval", 
                consumes = MediaType.APPLICATION_JSON_VALUE, 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> insertWorkInterval(@RequestBody NewWorkIntervalDto newWorkInterval) {
        return InsertWorkIntervalsController.execute(newWorkInterval);
    }

    @PutMapping(path = "/workInterval", 
                consumes = MediaType.APPLICATION_JSON_VALUE, 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> UpdateWorkInterval(@RequestBody FullWorkIntervalDto fullWorkInterval) {
        return UpdateWorkIntervalsController.execute(fullWorkInterval);
    }

    @DeleteMapping(path = "/workInterval", 
                consumes = MediaType.APPLICATION_JSON_VALUE, 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> DeleteWorkInterval(@RequestBody MinWorkIntervalDto minWorkInterval) {
    return DeleteWorkIntervalsController.execute(minWorkInterval);
    }

    @GetMapping(
            path = "/workIntervals",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<WorkIntervalDto>> getWorkIntervals(@RequestParam(value = "barberShopId") Integer barberShopId) {
        return GetWorkIntervalsByBarberShopController.execute(barberShopId);
    }
}
