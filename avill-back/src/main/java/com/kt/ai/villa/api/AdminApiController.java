package com.kt.ai.villa.api;

import com.kt.ai.villa.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminApiController {
    private final AdminService adminService;
}
