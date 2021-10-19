package com.onlinevn.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Novel {
    private @Id @GeneratedValue Integer id;

    private String name;
    private String description;
    private Integer genre;
    private Integer status;
    private Integer viewCount;

    private Integer firstFrame;

    protected Novel() {}

    public Novel(String name, String description, Integer genre, Integer status, Integer viewCount, Integer firstFrame) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.status = status;
        this.viewCount = viewCount;
        this.firstFrame = firstFrame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getFirstFrame() {
        return firstFrame;
    }

    public void setFirstFrame(Integer firstFrame) {
        this.firstFrame = firstFrame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novel novel = (Novel) o;
        return id.equals(novel.id) && name.equals(novel.name) && description.equals(novel.description) && genre.equals(novel.genre) && status.equals(novel.status) && viewCount.equals(novel.viewCount) && Objects.equals(firstFrame, novel.firstFrame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, genre, status, viewCount, firstFrame);
    }

    @Override
    public String toString() {
        return "Novel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genre=" + genre +
                ", status=" + status +
                ", viewCount=" + viewCount +
                ", firstFrame=" + firstFrame +
                '}';
    }

}
