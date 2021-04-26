package com.kt.ai.villa.rest.request.test;

import com.kt.ai.villa.model.v2.Test;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class CreateTestRequest {

    @NotEmpty
    private String test;

    @NotEmpty
    private String name;

    @Builder
    public CreateTestRequest(@NotEmpty String test, @NotEmpty String name) {
        this.test = test;
        this.name = name;
    }

    public Test toEntity(){
        return Test.builder()
                    .test(test)
                    .name(name)
                    .build();
    }
}
