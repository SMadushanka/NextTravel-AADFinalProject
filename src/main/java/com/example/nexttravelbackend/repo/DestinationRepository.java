package com.example.nexttravelbackend.repo;

import com.example.nexttravelbackend.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, String> {
    boolean existsByName(String name);

    Optional<Destination> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);

}
