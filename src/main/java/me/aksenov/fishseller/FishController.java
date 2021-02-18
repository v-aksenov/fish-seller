package me.aksenov.fishseller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.aksenov.fishseller.model.Fish;
import me.aksenov.fishseller.service.FishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class FishController {

    private final FishService fishService;

    @PostMapping("/add-fish")
    public void addFish(@RequestBody Fish fish) {
        fishService.addFish(fish);
    }

    @PostMapping("/get-fish")
    public Fish getFish(@RequestBody String title) {
        return fishService.getFish(title);
    }

    @GetMapping("/get-all")
    public List<Fish> getAll() {
        return fishService.getAllFish();
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception e) {
        log.info("mama :" + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
