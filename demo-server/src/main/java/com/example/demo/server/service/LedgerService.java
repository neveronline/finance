package com.example.demo.server.service;

import com.example.demo.server.request.AddEntryRequest;
import com.example.demo.server.request.CreateBucketRequest;
import com.example.demo.server.response.EntryResponseVO;

import java.util.List;
import java.util.Map;

public interface LedgerService {
    Boolean createBuckets(CreateBucketRequest request);

    Map<String, Double> getBucketSum(Integer loanId, List<String> bucketId);

    List<EntryResponseVO> getEntriesForALoan(Integer loanId);

    Boolean addEntries(AddEntryRequest request);
}
