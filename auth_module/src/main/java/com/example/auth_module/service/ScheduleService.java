package com.example.auth_module.service;

import com.example.auth_module.entity.UserPersonalData;
import com.example.auth_module.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@EnableScheduling
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private Logger log = LoggerFactory.getLogger(ScheduleService.class);

    private final UserRepository userRepository;

    @Scheduled(fixedDelay = 1800000L)
    private void checkTokenSession() {
        log.info("Планировщик начал работу " + LocalDateTime.now());
        List<UserPersonalData> users = userRepository.findUserPersonalDataByTokenIsNotNull();
        if (users.isEmpty()) {
            log.error("Нет текущих сессий.");
        } else {
            for (UserPersonalData user : users) {
                String token = user.getToken();
                LocalDateTime tokenDate = LocalDateTime.parse(token.substring(token.indexOf("|") + 1));
                if (tokenDate.isBefore(LocalDateTime.now())) {
                    user.setToken(null);
                    log.info("Токен пользователя " + user.getLogin() + " просрочен и был удалён.");
                }
                userRepository.save(user);
            }
            log.info("Планировщик завершил работу в " + LocalDateTime.now());
        }
    }
}
