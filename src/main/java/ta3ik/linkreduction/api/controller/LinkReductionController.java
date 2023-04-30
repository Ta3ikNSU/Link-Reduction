package ta3ik.linkreduction.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ta3ik.linkreduction.api.DTO.LinkDTO;
import ta3ik.linkreduction.service.LinkReductionService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@Slf4j
public class LinkReductionController {

    @Autowired
    private LinkReductionService linkReductionService;

    @PostMapping("/create")
    public ResponseEntity<LinkDTO> createLink(@RequestBody LinkDTO link) {
        log.info("Link received: {}", link);
        return ResponseEntity.ok(linkReductionService.createLink(link.getUrl()));
    }

    @GetMapping("/{key}")
    public void getLink(@PathVariable String key, HttpServletResponse response) throws IOException {
        log.info("Received redirect to: {}", key);
        response.sendRedirect("https://" + linkReductionService.getShortLink(key));
    }
}
