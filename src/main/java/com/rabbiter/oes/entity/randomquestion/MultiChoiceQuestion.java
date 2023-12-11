package com.rabbiter.oes.entity.randomquestion;

import lombok.Data;

/**
 * @author YMH
 * @version V1.0
 * @Package com.rabbiter.oes.entity.randomquestion
 * @date 2023/12/8/0008 16:01
 */
@Data
public class MultiChoiceQuestion {
    private Integer questionId;

    private String questionBank;
    private String subject;

    private String section;

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String question;

    private String level;

    private String rightAnswer;

    private String analysis; //题目解析

    private Integer score;
}
