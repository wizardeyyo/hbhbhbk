package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;

    public Message(String text, String tag) {

    }
}



