package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String flowType;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setName(String name) {
        this.name = name;
    }
}
