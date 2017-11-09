package com.darly.dubbo.study.impl;

import com.darly.dubbo.study.api.StudyApi;
import com.darly.dubbo.study.bean.Study;
import com.darly.dubbo.study.dto.StudyDTO;
import com.darly.dubbo.study.service.StudyService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO :
 */
@Service
public class StudyBiz implements StudyApi {

    @Autowired
    private StudyService studyService;

    @Override
    public List<StudyDTO> listStudys() {
        List<Study> studies = studyService.findAll();
        List<StudyDTO> listStudy = Lists.newArrayList();
         for(Study study: studies){
             StudyDTO studyDTO = new StudyDTO();
             studyDTO.setId(study.getId());
             studyDTO.setCode(study.getCode());
             studyDTO.setName(study.getName());
             studyDTO.setRemark(study.getRemark());
             listStudy.add(studyDTO);
         }
        return listStudy;
    }
}
