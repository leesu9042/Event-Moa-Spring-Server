package com.example.eventmoa.domain.dong.presentation;

import com.example.eventmoa.domain.dong.presentation.dto.request.DongCreateRequest;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryAllResponse;
import com.example.eventmoa.domain.dong.service.DongCreateService;
import com.example.eventmoa.domain.dong.service.DongQueryAllService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dong")
@Tag(name = "dong controller", description = "dong 관련 api")
public class DongController {
    private final DongCreateService dongCreateService;
    private final DongQueryAllService dongQueryAllService;

    @GetMapping("/queryAll")
    public List<DongQueryAllResponse> queryAll() {
        return dongQueryAllService.queryAll();
    }

    @PostMapping("/post")
    public void post(@Valid @RequestBody DongCreateRequest request) {
        dongCreateService.create(request);
    }
}
