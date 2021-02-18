package me.aksenov.fishseller.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.aksenov.fishseller.model.Fish;
import me.aksenov.fishseller.repository.FishRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FishService {

    private final FishRepository fishRepository;

    public void addFish(Fish fish) {
        if(fish.getPrice().compareTo(BigDecimal.ZERO) > 0) {
            fishRepository.save(fish);
        } else {
            throw new IllegalArgumentException("fish has negative price");
        }
    }

    public Fish getFish(String title) {
        return fishRepository.findByTitle(title).orElseThrow();
    }

    public List<Fish> getAllFish() {
        return fishRepository.findAll();
    }
}
