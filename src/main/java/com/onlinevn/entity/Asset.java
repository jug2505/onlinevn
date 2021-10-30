package com.onlinevn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Asset {

    private @Id @GeneratedValue Integer id;
    private String filename;
    private String type;
    private Integer novelId;

    protected Asset() {}

    public Asset(Integer id, String filename, String type, Integer novelId) {
        this.id = id;
        this.filename = filename;
        this.type = type;
        this.novelId = novelId;
    }

    public Asset(String filename, String type, Integer novelId) {
        this.filename = filename;
        this.type = type;
        this.novelId = novelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id) && Objects.equals(filename, asset.filename) && Objects.equals(type, asset.type) && Objects.equals(novelId, asset.novelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filename, type, novelId);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", type='" + type + '\'' +
                ", novelId=" + novelId +
                '}';
    }
}
