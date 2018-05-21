package com.hgg.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by hgg on 2018/5/21.
 */
@Repository
public interface SampleMapper {

    List<Map> getUserInfo();


}
