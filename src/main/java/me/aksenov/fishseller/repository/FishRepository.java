package me.aksenov.fishseller.repository;

import me.aksenov.fishseller.model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long> {

    Optional<Fish> findByTitle(String title);
}
