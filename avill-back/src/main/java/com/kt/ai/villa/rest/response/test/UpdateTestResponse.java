package com.kt.ai.villa.rest.response.test;

import com.kt.ai.villa.model.v2.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class UpdateTestResponse {
    private Long id;
    private String test;
    private String name;

    public UpdateTestResponse(Test test) {
        this.id = test.getId();
        this.test = test.getTest();
        this.name = test.getName();
    }
}
