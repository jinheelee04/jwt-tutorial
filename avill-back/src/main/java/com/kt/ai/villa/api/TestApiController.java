package com.kt.ai.villa.api;

import com.kt.ai.villa.model.v2.Test;
import com.kt.ai.villa.rest.request.test.CreateTestRequest;
import com.kt.ai.villa.rest.request.test.UpdateTestRequest;
import com.kt.ai.villa.rest.response.SeesawResponse;
import com.kt.ai.villa.rest.response.test.CreateTestResponse;
import com.kt.ai.villa.rest.response.test.TestListResponse;
import com.kt.ai.villa.rest.response.test.UpdateTestResponse;
import com.kt.ai.villa.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestApiController {

    private final TestService testService;

    /**
     * 생성
     */
    @PostMapping("/tests")
    public SeesawResponse<CreateTestResponse> createTest(
            @RequestBody @Valid CreateTestRequest request) {
        Test test = request.toEntity();
        //생성
        //Long id = testService.createTest(test);

        //테스트용 코드
        Long id = 1L;

        return SeesawResponse.ok(
                new CreateTestResponse(id));
    }

    /**
     * 전체 조회
     */
    @GetMapping("/tests")
    public SeesawResponse<TestListResponse> fetchTestList( ) {
        //전체 조회
        //List<Test> findTests = testService.fetchTestList();

        List<Test> findTests = new ArrayList<>();
        findTests.add(new Test(1L, "test1", "name1"));
        findTests.add(new Test(2L, "test2", "name2"));
        findTests.add(new Test(3L, "test3", "name3"));

        return SeesawResponse.ok(
               new TestListResponse(findTests.size(), findTests));
    }

    /**
     * 업데이트
     */
    @PatchMapping("/tests")
    public SeesawResponse<UpdateTestResponse> updateTest(
            @RequestBody @Validated UpdateTestRequest request) {

        //업데이트
        //testService.update(id, request.getTest());

        //업데이트한 test 조회
        //Test findTest = testService.findOne(id);

        //테스트용 코드
        Test findTest = new Test().builder()
                                .id(request.getId())
                                .test(request.getTest())
                                .build();

        return SeesawResponse.ok(
                new UpdateTestResponse(findTest));

    }


    /**
     * 삭제
     */
    @DeleteMapping("/tests/{id}")
    public SeesawResponse<?> removeTest(
            @PathVariable  @NotNull Long id) {

        //삭제
        //testService.removeTest(id);
        return SeesawResponse.ok();
    }
}
