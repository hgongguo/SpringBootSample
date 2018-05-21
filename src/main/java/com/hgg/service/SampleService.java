package com.hgg.service;

import com.hgg.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hgg on 2018/5/21.
 */
@Service
public class SampleService {

    @Autowired
    SampleMapper sampleMapper;

    public List<Map> getUserInfo(){
        return sampleMapper.getUserInfo();
    }

}
