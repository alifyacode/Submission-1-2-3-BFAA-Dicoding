package com.alifyacode.aplikasigithubuser.ApiHelp;

import com.alifyacode.aplikasigithubuser.UsersConfiguration.UsrGthb;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UGthbSearchRespon {
    @SerializedName("incomplete_results")
    private boolean incompleteResults;

    @SerializedName("items")
    private List<UsrGthb> items;


    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<UsrGthb> getItems() {
        return items;
    }

    public void setItems(List<UsrGthb> items) {
        this.items = items;
    }

    @Override
    public String toString(){
        return
                "UserSearchGithub{" +
                        ",incomplete_results = '" + incompleteResults + '\'' +
                        ",items = '" + items + '\'' +
                        "}";
    }
}
