package com.kt.ai.villa.rest.response.test;

import com.kt.ai.villa.model.v2.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class TestListResponse {

    private int count;
    private List<Test> testList;

}
