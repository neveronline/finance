package com.example.demo.server.response;

import lombok.Data;

@Data
public class EntryResponseVO extends EntryVO {
    private String createdAt;
    private String effectiveDate;
}
