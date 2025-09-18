package com.example.nexttravelbackend.service;

import com.example.nexttravelbackend.dto.TourPackageDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TourPackageService {
    int saveTourPackage(TourPackageDTO packageDTO);

    List<TourPackageDTO> getAllTourPackages();

    @Transactional
    int deleteTourPackage(Long id);

    @Transactional
    int updateTourPackage(Long id, TourPackageDTO tourPackageDTO);


}
