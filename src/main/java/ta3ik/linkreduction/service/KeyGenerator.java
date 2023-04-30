package ta3ik.linkreduction.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class KeyGenerator {
    @PostConstruct
    public void init() {
        maxValue = pow(alphabet.length(), 6);
    }
    private final AtomicLong atomicLong = new AtomicLong(0);

    private final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Long maxValue;

    public String nextKey() {
        atomicLong.compareAndSet(maxValue, 0);
        log.info("Atomic long: {}", atomicLong.get());
        String key = numberToChar(atomicLong.getAndIncrement());
        log.info("Key generated: {}", key);
        return key;
    }

    private String numberToChar(long number) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            long remainder = number % 52;
            sb.append(alphabet.charAt((int)remainder));
            number /= 52;
        }
        if (sb.length() == 0) {
            sb.append('a');
        }
        return sb.reverse().toString();
    }

    private long pow(long base, long exp) {
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
