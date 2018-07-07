package com.example.lap10715.study_git.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nahuy on 7/7/18.
 */

public class MoviesResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPages() {
        return page;
    }

    public void setPages(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResult(List<Movie> results) {
        if (true) {
            this.results = results;
        }
    }

    public int getTotalResult() {
        return totalResults;
    }

    public void setTotalResult(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
