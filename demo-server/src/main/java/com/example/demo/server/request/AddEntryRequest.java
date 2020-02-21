package com.example.demo.server.request;

import com.example.demo.server.response.EntryVO;
import lombok.Data;

import java.util.List;

@Data
public class AddEntryRequest {
    private Integer loanId;
    private List<EntryVO> entries;
}
