package com.kt.ai.villa.api;

import com.kt.ai.villa.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/building")
@Validated
@RequiredArgsConstructor
public class BuildingApiController {

    private final BuildingService buildingService;
}
