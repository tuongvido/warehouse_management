package com.example.warehouse_management.models.goods;

import com.example.warehouse_management.models.type.EUnit;
import com.example.warehouse_management.models.warehouse.BinPosition;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "goods")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String code;
    @Column(columnDefinition = "text",length = 255)
    private String name;
    @Enumerated(EnumType.STRING)
    private EUnit unit;
    @Column(name = "length", columnDefinition = "NUMERIC(5, 2) CHECK (length > 0)")
    private double length;
    @Column(name = "width", columnDefinition = "NUMERIC(5, 2) CHECK (width > 0)")
    private double width;
    @Column(name = "height", columnDefinition = "NUMERIC(5, 2) CHECK (height > 0)")
    private double height;
    @Column(name = "volume", columnDefinition = "NUMERIC(5, 2) CHECK (volume > 0)")
    private double volume;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy ="goods")
    private Set<BinPosition> binPositions;
    @Column(name = "image",nullable = true)
    private String image;

    public Goods(String name, EUnit unit, double length, double width, double height, double volume, Category category) {
        this.name = name;
        this.unit = unit;
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
        this.category = category;
    }
}
