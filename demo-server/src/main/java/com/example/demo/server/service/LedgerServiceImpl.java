package com.example.demo.server.service;

import com.example.demo.dal.bean.Bucket;
import com.example.demo.dal.bean.BucketExample;
import com.example.demo.dal.bean.Entry;
import com.example.demo.dal.bean.EntryExample;
import com.example.demo.dal.mapper.BucketDao;
import com.example.demo.dal.mapper.EntryDao;
import com.example.demo.dal.mapper.LoanDao;
import com.example.demo.server.request.AddEntryRequest;
import com.example.demo.server.request.CreateBucketRequest;
import com.example.demo.server.response.EntryResponseVO;
import com.example.demo.server.response.EntryVO;
import com.example.demo.server.utils.DateUtils;
import com.example.demo.server.utils.DoubleUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class LedgerServiceImpl implements LedgerService {
    @Resource
    private BucketDao bucketDao;
    @Resource
    private EntryDao entryDao;
    @Resource
    private LoanDao loanDao;

    @Override
    public Boolean createBuckets(CreateBucketRequest request) {
        if(request == null || StringUtils.isEmpty(request.getIdentifier())) {
            return false;
        }
        Bucket bucket = new Bucket();
        bucket.setName(request.getIdentifier());
        bucket.setLoanId(request.getLoanId());
        int result = bucketDao.insert(bucket);
        return result > 0;
    }

    @Override
    public Map<String, Double> getBucketSum(Integer loanId, List<String> bucketId) {
        BucketExample example = new BucketExample();
        example.createCriteria().andLoanIdEqualTo(loanId).andNameIn(bucketId);
        List<Bucket> buckets = bucketDao.selectByExample(example);
        Map<String, Double> result = new HashMap<>();
        for(Bucket bucket : buckets) {
            Integer balance = bucket.getBalance();
            result.put(bucket.getName(), DoubleUtils.convertMoney(balance));
        }
        return result;
    }

    @Override
    public List<EntryResponseVO> getEntriesForALoan(Integer loanId) {
        EntryExample example = new EntryExample();
        example.createCriteria().andLoadIdEqualTo(Long.valueOf(loanId));
        List<Entry> entries = entryDao.selectByExample(example);
        List<EntryResponseVO> result = new ArrayList<>();
        for(Entry entry : entries) {
            EntryResponseVO responseVO= new EntryResponseVO();
            responseVO.setValue(DoubleUtils.convertMoney(entry.getValue()));
            responseVO.setBucketId(entry.getBucketId());
            responseVO.setCreatedAt(DateUtils.formatter(entry.getCreatTime(), DateUtils.HOUR_PATTERN));
            responseVO.setEffectiveDate(DateUtils.formatter(entry.getEffectiveTime(), DateUtils.pattern));
            result.add(responseVO);
        }
        return result;
    }

    @Override
    public Boolean addEntries(AddEntryRequest request) {
        if(request == null) {
            return false;
        }
        List<Entry> entries = new ArrayList<>();
        for(EntryVO entryVO : request.getEntries()) {
            Entry entry = new Entry();
            entry.setBucketId(entryVO.getBucketId());
            entry.setLoadId(request.getLoanId().longValue());
            entry.setValue(DoubleUtils.convertMoney(entryVO.getValue()));
            entry.setCreatTime(new Date());
            entries.add(entry);
        }
        if(processEntries(entries)) {
            for(Entry entry : entries) {
                entry.setEffectiveTime(new Date());
                entryDao.insert(entry);
            }
        }
        return true;
    }

    private boolean processEntries(List<Entry> entries) {
        if(CollectionUtils.isEmpty(entries)) {
            return true;
        }
        for(Entry entry : entries) {
            Bucket bucket = bucketDao.selectByPrimaryKey(entry.getBucketId());
            bucket.setBalance(bucket.getBalance() + entry.getValue());
            int result = bucketDao.updateByPrimaryKeySelective(bucket);
            if(result <= 0) {
                return false;
            }
        }
        return true;
    }
}
