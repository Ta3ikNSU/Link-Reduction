package ta3ik.linkreduction.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import ta3ik.linkreduction.model.entity.Link;
import ta3ik.linkreduction.model.repository.LinkRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class KeyGenerator {

    @Autowired
    private LinkRepository linkRepository;

    private static final int MAX_KEY_LENGTH = 5;

    private final AtomicLong atomicLong = new AtomicLong(0);

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static Long maxValue = pow(alphabet.length(), MAX_KEY_LENGTH);

    @PostConstruct
    public void init() {
        Optional<Link> link = linkRepository.findTopByOrderByIdDesc();
        atomicLong.set(link.map(value -> value.getId() + 1).orElse(0L));
    }

    public Pair<Long, String> nextIdWithKey() {
        long id = atomicLong.getAndIncrement();
        log.info("Atomic long: {}", atomicLong.get());
        String key = numberToChar(id % maxValue);
        log.info("Key generated: {}", key);
        return Pair.of(id, key);
    }

    private String numberToChar(long number) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            long remainder = number % alphabet.length();
            sb.append(alphabet.charAt((int)remainder));
            number /= alphabet.length();
        }
        if (sb.length() == 0) {
            sb.append(alphabet.charAt(0));
        }
        return sb.reverse().toString();
    }

    private static long pow(long base, long exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        long halfExp = pow(base, exp / 2);
        if (exp % 2 == 0) {
            return halfExp * halfExp;
        } else {
            return halfExp * halfExp * base;
        }
    }
}
