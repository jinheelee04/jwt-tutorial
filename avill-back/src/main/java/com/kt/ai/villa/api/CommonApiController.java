package com.kt.ai.villa.api;

import com.kt.ai.villa.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
@Validated
@RequiredArgsConstructor
public class CommonApiController {

    private final CommonService commonService;


}
