package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "page")
public class Page {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    private String textSmall;

    public String getSmallText() {
        textSmall = text.substring(0, Math.min(text.length(), 100));
        if (text.length() > 100)
            textSmall += "...";
        return textSmall;
    }
}
