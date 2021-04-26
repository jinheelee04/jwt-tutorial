package com.kt.ai.villa.api;

import com.kt.ai.villa.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingApiController {
    private final ParkingService parkingService;
}
