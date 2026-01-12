package com.atipera.app.test;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GitService {
    private final String userName;
    private final String githubApiUrl;
    public GitService(@Value("${github.userName}") String userName, @Value("${github.api.url}") String githubApiUrl) {
        this.userName = userName;
        this.githubApiUrl = githubApiUrl;
    }

    public List<RepoResponse> getDatapack() throws IOException {
        GitHub gitHub = new GitHubBuilder()
                .withEndpoint(githubApiUrl)
                .build();
        GHUser ghUser = gitHub.getUser(userName);

        return ghUser.getRepositories().values().stream()
                .filter(repo -> !repo.isFork()).map(repo -> {
                    List<BranchResponse> branchResponse = null;
                    try {
                        branchResponse = repo.getBranches().values().stream().map(
                                        branch -> new BranchResponse(branch.getName(), branch.getSHA1()))
                                .collect(Collectors.toList());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return new RepoResponse(repo.getName(), ghUser.getLogin(), branchResponse);
                }).toList();
    }

    public String getToken() {
        return userName;
    }
}

