package com.rabbiter.oes.service.ramdonquestion;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rabbiter.oes.entity.randomquestion.MultiChoiceQuestion;
import com.rabbiter.oes.excel.MultiChoiceExcel;
import com.rabbiter.oes.vo.param.RandomQuestionParam;

import java.io.InputStream;
import java.util.List;

/**
 * @author YMH
 * @version V1.0
 * @Package com.rabbiter.oes.service.ramdonquestion.impl
 * @date 2023/12/8/0008 16:25
 */
public interface MultiChoiceQuestionService extends IService<MultiChoiceQuestion> {
    /**
     * 获取随机选择题
     *
     * @param param
     * @return
     */
    List<MultiChoiceQuestion> getRandomMultiQuestion(RandomQuestionParam param);

    /**
     * 导入数据
     *
     * @param inputStream
     */
    void importMulti(InputStream inputStream);

    /**
     * 创建选择题数据
     *
     * @param cachedDataList
     * @return
     */
    int createMultiQuestion(List<MultiChoiceExcel> cachedDataList);
}
