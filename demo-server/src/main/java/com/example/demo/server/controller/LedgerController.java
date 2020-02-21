package com.example.demo.server.controller;

import com.example.demo.server.request.AddEntryRequest;
import com.example.demo.server.request.CreateBucketRequest;
import com.example.demo.server.response.EntryResponseVO;
import com.example.demo.server.service.LedgerService;
import com.example.demo.server.utils.JsonUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ledger")
public class LedgerController {

    @Resource
    private LedgerService ledgerService;
    @PostMapping("/buckets")
    public Boolean createBucket(@RequestBody CreateBucketRequest request) {
        return ledgerService.createBuckets(request);
    }
    @GetMapping("/buckets/sum")
    public String getSumOfBuckets(@RequestParam("loanId") Integer loanId,
                               @RequestParam("bucketids") List<String> bucketIds) {
        Map<String, Double> result = ledgerService.getBucketSum(loanId, bucketIds);
        return JsonUtils.object2Json(result, true);
    }

    @GetMapping("/entries")
    public String getEntries(@RequestParam("loanId") Integer loanId) {
        List<EntryResponseVO> result = ledgerService.getEntriesForALoan(loanId);
        return JsonUtils.object2Json(result, true);
    }

    @PostMapping("/entries")
    public Boolean addEntries(@RequestBody AddEntryRequest request) {
        return ledgerService.addEntries(request);
    }

}
