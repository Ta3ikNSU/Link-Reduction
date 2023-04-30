package ta3ik.linkreduction.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ta3ik.linkreduction.api.DTO.LinkDTO;
import ta3ik.linkreduction.model.entity.Link;
import ta3ik.linkreduction.model.repository.LinkRepository;

@Service
@Slf4j
public class LinkReductionService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private KeyGenerator keyGenerator;

    public LinkDTO createLink(String link) {
        Link savedLink = linkRepository.save(new Link(keyGenerator.nextKey(), link));
        log.info("Link saved: {}", savedLink);
        return new LinkDTO(savedLink.getKey());
    }

    public String getShortLink(String key) {
        Link link = linkRepository.findByKey(key);
        log.info("Link found: {}", link);
        return link.getUrl();
    }
}
