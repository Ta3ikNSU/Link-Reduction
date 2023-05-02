package ta3ik.linkreduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ta3ik.linkreduction.model.entity.Link;
import ta3ik.linkreduction.model.exception.LinkNotFoundException;
import ta3ik.linkreduction.model.repository.LinkRepository;

import java.util.Optional;

@Service
public class RedirectionService {
    @Autowired
    private ShortLinkService shortLinkService;

    public String getRedirectUrl(String key) throws LinkNotFoundException {
        return shortLinkService.getShortLink(key);
    }
}
