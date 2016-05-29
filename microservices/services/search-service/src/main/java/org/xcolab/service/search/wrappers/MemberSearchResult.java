package org.xcolab.service.search.wrappers;

public class MemberSearchResult {

    private String firstName;
    private String lastName;
    private String screenName;
    private String shortBio;
    private Double relevance;

    public SearchResult getSearchResult(String query) {
        final String title = String.format("%s (%s %s)", screenName, firstName, lastName);
        final String content = shortBio;
        return new SearchResult(title, content, relevance, query);
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Double getRelevance() {
        return relevance;
    }

    public void setRelevance(Double relevance) {
        this.relevance = relevance;
    }
}
