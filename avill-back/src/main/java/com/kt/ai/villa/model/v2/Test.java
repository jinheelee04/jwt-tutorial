package com.kt.ai.villa.model.v2;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Test {
    private Long id;
    private String test;
    private String name;

    @Builder
    public Test(Long id, String test, String name) {
        this.id = id;
        this.test = test;
        this.name = name;
    }
}
