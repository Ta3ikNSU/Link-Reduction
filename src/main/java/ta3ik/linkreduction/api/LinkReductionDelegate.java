package ta3ik.linkreduction.api;

import linkreduction.api.LinkApiDelegate;
import linkreduction.model.LinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ta3ik.linkreduction.service.LinkReductionService;

import java.net.URI;

@Component
public class LinkReductionDelegate implements LinkApiDelegate {

    @Autowired
    private LinkReductionService linkReductionService;

    @Override
    public ResponseEntity<LinkDTO> createLink(LinkDTO link) {
        return ResponseEntity.ok(linkReductionService.getShortLink(link.getUrl()));
    }
}
