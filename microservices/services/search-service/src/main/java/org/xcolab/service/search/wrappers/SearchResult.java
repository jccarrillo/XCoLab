package org.xcolab.service.search.wrappers;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;

public class SearchResult {

    private static final String HIGHLIGHT_TAG_OPEN = "<b>";
    private static final String HIGHLIGHT_TAG_CLOSE = "</b>";

    private static final int TITLE_TEXT_LENGTH = 60;
    private static final int CONTENT_TEXT_LENGTH = 300;

    private String title;
    private String content;
    private Double relevance;
    private boolean isHighlighted = false;

    public SearchResult() {
    }

    public SearchResult(String title, String content, Double relevance, String highlightPhrase) {
        this.title = title;
        this.content = content;
        this.relevance = relevance;
        applyHighlight(highlightPhrase);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = stripFormatting(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = stripFormatting(content);
    }

    public void applyHighlight(String highlightPhrase) {
        if (!isHighlighted) {
            abbreviateFields();

            final String[] highlightWords = StringUtils.split(highlightPhrase, ' ');

            for (String highlightWord : highlightWords) {
                if (title != null) {
                    title = title.replaceAll(highlightWord,
                            HIGHLIGHT_TAG_OPEN + highlightWord + HIGHLIGHT_TAG_CLOSE);
                } else {
                    title = "Unknown title";
                }
                if (content != null) {
                    content = content.replaceAll(highlightWord,
                            HIGHLIGHT_TAG_OPEN + highlightWord + HIGHLIGHT_TAG_CLOSE);
                } else {
                    content = "";
                }
            }
            isHighlighted = true;
        }
    }

    private void abbreviateFields() {
        title = StringUtils.abbreviate(title, TITLE_TEXT_LENGTH);
        //TODO: abbreviate content field
    }

    private String stripFormatting(String formattedText) {
        return Jsoup.parse(formattedText).text();
    }

    public Double getRelevance() {
        return relevance;
    }

    public void setRelevance(Double relevance) {
        this.relevance = relevance;
    }
}
