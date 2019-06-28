package com.vivat.practice.model;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private long year;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Score level;

    public Movie() {

    }

    public Movie(String title, long year, Score level) {
        this.title = title;
        this.year = year;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public Score getLevel() {
        return level;
    }

    public void setLevel(Score level) {
        this.level = level;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append("Movie{")
            .append("id=" + id)
            .append(", title='" + title + '\'')
            .append(", year=" + year)
            .append(", score=" + level);

        if (producer != null) {
            builder.append(", producer=" + producer.getName());
        }

        builder.append('}');
        return builder.toString();
    }
}
