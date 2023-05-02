package ta3ik.linkreduction.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import ta3ik.linkreduction.api.DTO.LinkDTO;
import ta3ik.linkreduction.model.entity.Link;
import ta3ik.linkreduction.model.exception.LinkNotFoundException;
import ta3ik.linkreduction.model.repository.LinkRepository;

import java.util.Optional;

@Service
@Slf4j
public class ShortLinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private KeyGenerator keyGenerator;

    public LinkDTO createLink(String link) {
        Pair<Long, String> idWithKey = keyGenerator.nextIdWithKey();
        Link savedLink = linkRepository.save(new Link(idWithKey.getFirst(), idWithKey.getSecond(), link));
        log.info("Link saved: {}", savedLink);
        return new LinkDTO(savedLink.getKey());
    }

    public String getShortLink(String key) throws LinkNotFoundException {
        Optional<Link> link = linkRepository.findByKey(key);
        return link.orElseThrow(() -> new LinkNotFoundException(String.format("Invalid key : %s.", key))).getUrl();
    }
}
