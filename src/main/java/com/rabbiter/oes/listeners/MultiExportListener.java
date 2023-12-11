package com.rabbiter.oes.listeners;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.rabbiter.oes.excel.MultiChoiceExcel;
import com.rabbiter.oes.service.ramdonquestion.MultiChoiceQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author YMH
 * @version V1.0
 * @Package com.rabbiter.oes.listeners
 * @date 2023/12/8/0008 17:50
 */
@Slf4j
public class MultiExportListener extends AnalysisEventListener<MultiChoiceExcel> {
    /**
     * 每隔100条存储数据库，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    /**
     * 缓存的数据
     */
    private List<MultiChoiceExcel> cachedDataList = new ArrayList<MultiChoiceExcel>(BATCH_COUNT);
    /**
     * 导入成功数
     */
    private Integer sucTotal;

    /**
     * 导入失败数
     */
    private Integer failTotal;

    private Long failId;


    private MultiChoiceQuestionService multiChoiceQuestionService;


    public MultiExportListener() {

    }

    public MultiExportListener(MultiChoiceQuestionService multiChoiceQuestionService) {
        this.multiChoiceQuestionService = multiChoiceQuestionService;
        failTotal = 0;
        sucTotal = 0;
    }


    @Override
    public void invoke(MultiChoiceExcel multiChoiceExcel, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (!CollectionUtils.isEmpty(cachedDataList)) {
            multiChoiceQuestionService.createMultiQuestion(cachedDataList);
        }
    }
}
