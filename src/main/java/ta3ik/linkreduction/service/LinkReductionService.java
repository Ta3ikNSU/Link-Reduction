package ta3ik.linkreduction.service;

import linkreduction.model.LinkDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ta3ik.linkreduction.model.entity.Link;
import ta3ik.linkreduction.model.mapper.LinkMapper;
import ta3ik.linkreduction.model.repository.LinkRepository;

@Service
@Slf4j
public class LinkReductionService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private LinkMapper linkMapper;

    public LinkDTO getShortLink(String link) {
        Link savedLink = linkRepository.save(new Link(link));
        log.info("Link saved: {}", savedLink);
        return linkMapper.toDTO(savedLink);
    }
}
