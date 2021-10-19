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

    protected Asset() {}

    public Asset(Integer id, String filename, String type) {
        this.id = id;
        this.filename = filename;
        this.type = type;
    }

    public Asset(String filename, String type) {
        this.filename = filename;
        this.type = type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return id.equals(asset.id) && filename.equals(asset.filename) && type.equals(asset.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filename, type);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
