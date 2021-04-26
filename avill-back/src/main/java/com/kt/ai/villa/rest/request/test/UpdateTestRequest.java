package com.kt.ai.villa.rest.request.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UpdateTestRequest {
    @NotNull
    private Long id;

    @NotBlank
    private String test;

    @Builder
    public UpdateTestRequest(@NotBlank Long id, @NotEmpty String test) {
        this.id = id;
        this.test = test;
    }
}
