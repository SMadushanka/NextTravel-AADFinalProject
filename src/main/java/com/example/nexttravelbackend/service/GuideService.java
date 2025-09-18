package com.example.nexttravelbackend.service;


import com.example.nexttravelbackend.dto.GuideDTO;

import java.util.List;

public interface GuideService {

    int saveGuide(GuideDTO guideDTO);

    int updateGuide(String email, GuideDTO guideDTO);

    int deactivateGuide(String email);

    int activateGuide(String email);

    List<GuideDTO> getAllGuides();

    List<GuideDTO> getAvailableGuides();

    int getTotalGuideCount();
}
''