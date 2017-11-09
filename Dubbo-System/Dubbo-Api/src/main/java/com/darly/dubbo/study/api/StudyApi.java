package com.darly.dubbo.study.api;

import com.darly.dubbo.study.dto.StudyDTO;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO :
 */
public interface StudyApi {

    List<StudyDTO> listStudys();
}
