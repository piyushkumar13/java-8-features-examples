package com.piyush.practice.domain.model;

import lombok.*;

/**
 * @author Piyush Kumar.
 * @since 8/11/18.
 */

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Student {
    private int id;
    private String name;
    private String address;
    private int markPercentage;
    private String subject;
    private String[] courses;

}
