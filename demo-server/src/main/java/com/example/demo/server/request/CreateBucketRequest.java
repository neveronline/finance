package com.example.demo.server.request;

import lombok.Data;

@Data
public class CreateBucketRequest {
    private String identifier;
    private Integer loanId;
}
