package com.real.realoasis.domain.diary.schedule;

import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DailyScheduler {
    private final UserRepository userRepository;

    @Scheduled(cron = "0 15 10 * * *")
    public void executeDailyTask() {
        List<User> userList = userRepository.findAll();
        for (User user: userList) {
            user.resetDailyCount();
        }
    }
}
