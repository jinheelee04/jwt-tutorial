package com.jwt.tutorial.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 데이터베이스의 테이블과 1:1 매핑되는 객체
@Table(name="authority") // 테이블명 지정
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    @Id
    @Column(name="authority_name", length=50)
    private String authorityName;
}
