package ru.soular.kafkahomework.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.soular.kafkahomework.kafka.producer.KafkaProducer;

@RestController
@RequiredArgsConstructor
public class BaseController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/test")
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        kafkaProducer.send(message);

        return ResponseEntity.ok("Message has been sent");
    }
}
