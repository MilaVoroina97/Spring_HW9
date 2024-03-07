package com.voronina.gb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Record {

    private int id;
    private String title;
    private String content;
    private String createdDate;

}
