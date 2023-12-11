package com.rabbiter.oes.service.ramdonquestion.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.oes.entity.randomquestion.MultiChoiceQuestion;
import com.rabbiter.oes.excel.MultiChoiceExcel;
import com.rabbiter.oes.listeners.MultiExportListener;
import com.rabbiter.oes.mapper.randomquestion.MultiChoiceQuestionMapper;
import com.rabbiter.oes.service.ramdonquestion.MultiChoiceQuestionService;
import com.rabbiter.oes.vo.param.RandomQuestionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * @author YMH
 * @version V1.0
 * @Package com.rabbiter.oes.service.ramdonquestion.impl
 * @date 2023/12/8/0008 16:25
 */
@Service
public class MultiChoiceQuestionServiceImpl extends ServiceImpl<MultiChoiceQuestionMapper, MultiChoiceQuestion> implements MultiChoiceQuestionService {
    @Autowired
    private MultiChoiceQuestionMapper choiceQuestionMapper;
    /**
     * 获取随机选择题
     *
     * @param param
     * @return
     */
    @Override
    public List<MultiChoiceQuestion> getRandomMultiQuestion(RandomQuestionParam param) {

        return choiceQuestionMapper.getRandomMultiQuestion(param);
    }

    @Override
    public void importMulti(InputStream inputStream) {
        try {
            MultiExportListener contractExportListener = new MultiExportListener(this);
            EasyExcel.read(inputStream, MultiChoiceExcel.class, contractExportListener).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
