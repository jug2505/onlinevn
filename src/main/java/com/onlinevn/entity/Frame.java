package com.onlinevn.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Frame {
    private @Id @GeneratedValue Integer id;
    private Integer novel;
    private Integer frameType;
    private String text;
    private String name;
    private Integer nextFrame;
    private Integer prevFrame;

    @ManyToMany
    @JoinTable(
            name = "frame_item",
            joinColumns = {@JoinColumn(name = "frame_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")}
    )
    private List<Item> items = new ArrayList<>();

    protected Frame() {}

    public Frame(Integer id, Integer novel, Integer frameType, String text, String name, Integer nextFrame, Integer prevFrame, List<Item> items) {
        this.id = id;
        this.novel = novel;
        this.frameType = frameType;
        this.text = text;
        this.name = name;
        this.nextFrame = nextFrame;
        this.prevFrame = prevFrame;
        this.items = items;
    }

    public Frame(Integer novel, Integer frameType, String text, String name, Integer prevFrame, Integer nextFrame, List<Item> items) {
        this.novel = novel;
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

    public Integer getNovel() {
        return novel;
    }

    public void setNovel(Integer novel) {
        this.novel = novel;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return id.equals(frame.id) && Objects.equals(novel, frame.novel) && Objects.equals(frameType, frame.frameType) && Objects.equals(text, frame.text) && Objects.equals(name, frame.name) && Objects.equals(nextFrame, frame.nextFrame) && Objects.equals(prevFrame, frame.prevFrame) && Objects.equals(items, frame.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, novel, frameType, text, name, nextFrame, prevFrame, items);
    }

    @Override
    public String toString() {
        return "Frame{" +
                "id=" + id +
                ", novel=" + novel +
                ", frameType=" + frameType +
                ", text='" + text + '\'' +
                ", name='" + name + '\'' +
                ", nextFrame=" + nextFrame +
                ", prevFrame=" + prevFrame +
                ", items=" + items +
                '}';
    }
}
