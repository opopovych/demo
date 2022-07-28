package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String type;
    @Lob
    private String image;



    public Coffee() {
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description="
                + description + ", price=" + ", image="
                + image + "Type= "+ type +"]";
    }
}
