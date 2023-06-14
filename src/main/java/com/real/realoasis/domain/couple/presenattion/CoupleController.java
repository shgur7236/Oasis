package com.real.realoasis.domain.couple.presenattion;

import com.real.realoasis.domain.couple.service.EnterDatingDateService;
import com.real.realoasis.domain.user.presentation.data.dto.EnterDto;
import com.real.realoasis.domain.user.presentation.data.dto.MainPageDto;
import com.real.realoasis.domain.user.presentation.data.request.DatingDateEnterRequest;
import com.real.realoasis.domain.user.presentation.data.response.MainPageResponse;
import com.real.realoasis.domain.couple.service.MainPageService;
import com.real.realoasis.domain.couple.util.CoupleConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couple")
@RequiredArgsConstructor
public class CoupleController {
    private final MainPageService mainPageService;
    private final EnterDatingDateService enterDatingDateService;
    private final CoupleConverter coupleConverter;

    @GetMapping
    public ResponseEntity<MainPageResponse> getMainPage(){
        MainPageDto mainPageDto = mainPageService.getMainPage();
        MainPageResponse mainPageResponse = coupleConverter.toResponse(mainPageDto);
        return new ResponseEntity<>( mainPageResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> datingDateEnter(@RequestBody DatingDateEnterRequest datingDateEnterRequest){
        EnterDto enterDto = coupleConverter.toEnterDto(datingDateEnterRequest);
        enterDatingDateService.enter(enterDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}