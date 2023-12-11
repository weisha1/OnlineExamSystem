package com.rabbiter.oes.mapper.randomquestion;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rabbiter.oes.entity.randomquestion.MultiChoiceQuestion;
import com.rabbiter.oes.vo.param.RandomQuestionParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YMH
 * @version V1.0
 * @Package com.rabbiter.oes.mapper.randomquestion
 * @date 2023/12/8/0008 16:13
 */
@Mapper
public interface MultiChoiceQuestionMapper extends BaseMapper<MultiChoiceQuestion> {
    /**
     * 获取随机选择题
     *
     * @param param
     * @return
     */
    List<MultiChoiceQuestion> getRandomMultiQuestion(@Param("param") RandomQuestionParam param);
}
