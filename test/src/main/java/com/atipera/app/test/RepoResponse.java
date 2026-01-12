package com.atipera.app.test;

import java.util.List;

public class RepoResponse {
    String repositoryName;
    String ownerLogin;
    List<BranchResponse> listOfBranches;
    public RepoResponse(String repositoryName, String ownerLogin, List<BranchResponse> listOfBranches) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
        this.listOfBranches = listOfBranches;

    }
    public String getRepositoryName() {
        return repositoryName;
    }
    public String getOwnerLogin() {
        return ownerLogin;
    }
    public List<BranchResponse> getListOfBranches() {
        return listOfBranches;
    }
}
