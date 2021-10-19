package com.onlinevn.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Frame {
    private @Id @GeneratedValue Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    private Novel novel;

    private Integer frameType;
    private String text;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Frame nextFrame;

    @OneToOne(fetch = FetchType.LAZY)
    private Frame prevFrame;

    protected Frame() {}

    public Frame(Novel novel, Integer frameType, String text, String name, Frame nextFrame, Frame prevFrame) {
        this.novel = novel;
        this.frameType = frameType;
        this.text = text;
        this.name = name;
        this.nextFrame = nextFrame;
        this.prevFrame = prevFrame;
    }

    public Integer getId() {
        return id;
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
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

    public Frame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public Frame getPrevFrame() {
        return prevFrame;
    }

    public void setPrevFrame(Frame prevFrame) {
        this.prevFrame = prevFrame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return id.equals(frame.id) && novel.equals(frame.novel) && frameType.equals(frame.frameType) && text.equals(frame.text) && name.equals(frame.name) && Objects.equals(nextFrame, frame.nextFrame) && Objects.equals(prevFrame, frame.prevFrame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, novel, frameType, text, name, nextFrame, prevFrame);
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
                '}';
    }
}
