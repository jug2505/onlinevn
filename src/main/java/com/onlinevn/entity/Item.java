package com.onlinevn.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Item {

    private @Id @GeneratedValue Integer id;
    private Integer coordX;
    private Integer coordY;
    private Integer assetId;

    protected Item() {}

    public Item(Integer id, Integer coordX, Integer coordY, Integer assetId) {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
        this.assetId = assetId;
    }

    public Item(Integer coordX, Integer coordY, Integer assetId) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.assetId = assetId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoordX() {
        return coordX;
    }

    public void setCoordX(Integer coordX) {
        this.coordX = coordX;
    }

    public Integer getCoordY() {
        return coordY;
    }

    public void setCoordY(Integer coordY) {
        this.coordY = coordY;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer asset) {
        this.assetId = asset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) && coordX.equals(item.coordX) && coordY.equals(item.coordY) && assetId.equals(item.assetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordX, coordY, assetId);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", asset=" + assetId +
                '}';
    }
}
