package com.example.eventmoa.domain.dong.service;

import com.example.eventmoa.domain.dong.persistence.repository.DongRepository;
import com.example.eventmoa.domain.dong.presentation.dto.request.DongHanRequest;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryAllList;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryhanList;
import com.example.eventmoa.domain.dong.presentation.dto.response.DongQueryhanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DongHanService {
    private final DongRepository dongRepository;
    private final RestTemplate restTemplate;

    public ResponseEntity<File> makeHan(DongHanRequest request){
        DongQueryhanResponse response = new DongQueryhanResponse(queryAll(request));
        String url = "http://localhost:9090/test/han";
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(response), File.class);


    }

    public List<DongQueryhanList> queryAll(DongHanRequest request) {
        return dongRepository.findAllByOrderByDateAscTimeAscDongAsc()
                .stream()
                .filter(d -> getTime(d.getDate()) >= getTime(request.getStartDate()) && getTime(d.getDate()) <= getTime(request.getEndDate()))
                .map(DongQueryhanList::new)
                .toList();
    }

    private long getTime(String date) {
        date = date.substring(0, 8);
        String[] time = date.split("\\.");
        return Integer.parseInt((time[0]+time[1]+time[2]));
    }
}
