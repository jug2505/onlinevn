package com.onlinevn.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Item {

    private @Id @GeneratedValue Integer id;
    private Integer coordX;
    private Integer coordY;
    private @OneToOne(fetch = FetchType.EAGER) Asset asset;

    protected Item() {}

    public Item(Integer coordX, Integer coordY, Asset asset) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.asset = asset;
    }

    public Integer getId() {
        return id;
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

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) && coordX.equals(item.coordX) && coordY.equals(item.coordY) && asset.equals(item.asset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordX, coordY, asset);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", asset=" + asset +
                '}';
    }
}
