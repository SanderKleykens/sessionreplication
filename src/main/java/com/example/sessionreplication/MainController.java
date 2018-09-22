package com.example.sessionreplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.WebSession;

import java.net.InetAddress;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @GetMapping
    public String sessionReplication(final WebSession webSession,
                                     final Model model) {

        Integer hits = webSession.getAttribute("hits");

        if (hits == null) {
            hits = 0;
        }

        System.out.println("Hits " + hits + " for session id " + webSession.getId());

        model.addAttribute("sessionId", webSession.getId());

        webSession.getAttributes().put("hits", ++hits);

        model.addAttribute("hits", hits);

        try {
            model.addAttribute("hostName", InetAddress.getLocalHost().getHostName());
        } catch (Exception e) {
            // Ignore
        }

        return "session-replication";
    }
}
