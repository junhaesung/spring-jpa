package com.nhn.edu.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MemberDetails")
@Data
public class MemberDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_detail_id")
    private Long memberDetailId;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
