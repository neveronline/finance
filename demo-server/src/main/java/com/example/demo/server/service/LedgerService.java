package com.example.demo.server.service;

import com.example.demo.server.request.AddEntryRequest;
import com.example.demo.server.request.CreateBucketRequest;
import com.example.demo.server.response.EntryResponseVO;

import java.util.List;
import java.util.Map;

public interface LedgerService {
    /**
     * create buckets for a loan
     * @param request
     * @return
     */
    Boolean createBuckets(CreateBucketRequest request);

    /**
     * get the balance sum of exsited buckets
     * @param loanId
     * @param bucketId
     * @return
     */
    Map<String, Double> getBucketSum(Integer loanId, List<String> bucketId);

    /**
     * get all entries for a specific loan
     * @param loanId
     * @return
     */
    List<EntryResponseVO> getEntriesForALoan(Integer loanId);

    /**
     * add entries to the record and process the record
     * @param request
     * @return
     */
    Boolean addEntries(AddEntryRequest request);
}
