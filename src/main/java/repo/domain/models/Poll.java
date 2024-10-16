package repo.domain.models;

import java.time.Instant;

public class Poll {
    private String question;
    private Instant publishedAt;
    private Instant validUntil;

    public Poll() {}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
