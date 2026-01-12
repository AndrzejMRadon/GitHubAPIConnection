package com.atipera.app.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequestMapping("/github")
@RestController
public class RController {
    private final GitService gitService;
    public RController(GitService gitService) {
        this.gitService = gitService;
    }
    @GetMapping("/repos")
    public ResponseEntity<List<RepoResponse>> getRepos() throws IOException {
        return ResponseEntity.ok(gitService.getDatapack());
    }
}
