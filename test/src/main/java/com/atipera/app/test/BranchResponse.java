package com.atipera.app.test;

public class BranchResponse {
    String name;
    String lastCommitSha;
    public BranchResponse(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }
    public String getName() {
        return name;
    }
    public String getLastCommitSha() {
        return lastCommitSha;
    }

}
