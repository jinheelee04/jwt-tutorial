package com.kt.ai.villa.api;

import com.kt.ai.villa.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaint")
@Validated
@RequiredArgsConstructor
public class ComplaintApiController {

    private final ComplaintService complaintService;
}
