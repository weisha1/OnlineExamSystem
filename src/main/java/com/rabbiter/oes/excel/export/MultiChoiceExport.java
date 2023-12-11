package com.rabbiter.oes.excel.export;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author YMH
 * @version V1.0
 * @Package com.rabbiter.oes.excel
 * @date 2023/12/8/0008 17:32
 */
@Data
public class MultiChoiceExport {
    @ExcelProperty({"问题题目"})
    private String question;
    @ExcelProperty({"选项A"})
    private String answerA;
    @ExcelProperty({"选项B"})
    private String answerB;
    @ExcelProperty({"选项C"})
    private String answerC;
    @ExcelProperty({"选项D"})
    private String answerD;
    @ExcelProperty({"正确答案"})
    private String rightAnswer;
    @ExcelProperty({"题目解析"})
    private String analysis;
    @ExcelProperty({"分数"})
    private String score;
    @ExcelProperty({"所属章节"})
    private String section;
    @ExcelProperty({"难度等级"})
    private String level;

}
