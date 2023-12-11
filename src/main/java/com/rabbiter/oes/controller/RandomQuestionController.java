package com.rabbiter.oes.controller;

import com.rabbiter.oes.entity.ApiResult;
import com.rabbiter.oes.entity.randomquestion.MultiChoiceQuestion;
import com.rabbiter.oes.service.ramdonquestion.MultiChoiceQuestionService;
import com.rabbiter.oes.util.ApiResultHandler;
import com.rabbiter.oes.vo.param.RandomQuestionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YMH
 * @version V1.0
 * @Package com.rabbiter.oes.controller
 * @date 2023/12/8/0008 11:12
 */
@RestController
public class RandomQuestionController {
    @Autowired
    private MultiChoiceQuestionService multiChoiceQuestionService;


    @GetMapping("/randomQuestion")
    public ApiResult randomQuestion(RandomQuestionParam param){
        Map<Integer, List<?>> map = new HashMap<>();
        List<MultiChoiceQuestion> choiceQuestion=multiChoiceQuestionService.getRandomMultiQuestion(param);
        map.put(1,choiceQuestion);
        return ApiResultHandler.buildApiResult(200,"随机试题功能",map);
    }
}
