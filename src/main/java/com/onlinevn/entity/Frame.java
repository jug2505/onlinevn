package com.onlinevn.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Frame {
    private @Id @GeneratedValue Integer id;
    private Integer novelId;
    private Integer frameType;
    private String text;
    private String name;
    private Integer nextFrame;
    private Integer prevFrame;
    @ElementCollection
    private List<Integer> items = new ArrayList<>();

    protected Frame() {}

    public Frame(Integer id, Integer novelId, Integer frameType, String text, String name, Integer nextFrame, Integer prevFrame, List<Integer> items) {
        this.id = id;
        this.novelId = novelId;
        this.frameType = frameType;
        this.text = text;
        this.name = name;
        this.nextFrame = nextFrame;
        this.prevFrame = prevFrame;
        this.items = items;
    }

    public Frame(Integer novelId, Integer frameType, String text, String name, Integer prevFrame, Integer nextFrame, List<Integer> items) {
        this.novelId = novelId;
        this.frameType = frameType;
        this.text = text;
        this.name = name;
        this.nextFrame = nextFrame;
        this.prevFrame = prevFrame;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novel) {
        this.novelId = novel;
    }

    public Integer getFrameType() {
        return frameType;
    }

    public void setFrameType(Integer frameType) {
        this.frameType = frameType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Integer nextFrame) {
        this.nextFrame = nextFrame;
    }

    public Integer getPrevFrame() {
        return prevFrame;
    }

    public void setPrevFrame(Integer prevFrame) {
        this.prevFrame = prevFrame;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return id.equals(frame.id) && Objects.equals(novelId, frame.novelId) && Objects.equals(frameType, frame.frameType) && Objects.equals(text, frame.text) && Objects.equals(name, frame.name) && Objects.equals(nextFrame, frame.nextFrame) && Objects.equals(prevFrame, frame.prevFrame) && Objects.equals(items, frame.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, novelId, frameType, text, name, nextFrame, prevFrame, items);
    }

    @Override
    public String toString() {
        return "Frame{" +
                "id=" + id +
                ", novel=" + novelId +
                ", frameType=" + frameType +
                ", text='" + text + '\'' +
                ", name='" + name + '\'' +
                ", nextFrame=" + nextFrame +
                ", prevFrame=" + prevFrame +
                ", items=" + items +
                '}';
    }
}
