package com.funtl.community.controller;

import com.funtl.community.dto.AccesstokenDTO;
import com.funtl.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;
    
    @GetMapping(name="/callback")
    public String callback(@RequestParam(value = "code")String code,@RequestParam(value = "state")String state){
        AccesstokenDTO accesstokenDTO=new AccesstokenDTO();
        accesstokenDTO.setClient_id("Iv1.5db642a2f75a8593");
        accesstokenDTO.setClient_secret("fe0dfad4927442359716683227c5f794dc7430d5");
        accesstokenDTO.setCode(code);
        accesstokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accesstokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accesstokenDTO);


        return "index";
    }
}
