package com.glyxybxhtxt.exception;

import com.glyxybxhtxt.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


/**
 * Author:wangzh
 * Date: 2020/11/1 14:54
 * Version: 1.0
 */
@ControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * ���������쳣
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResponseData exceptionHandler(Exception e){
        logger.error("δ֪�쳣��ԭ����:",e);
        return new ResponseData("1");
    }

    /**
     * ����ת���쳣
     * @param e
     * @return
     */
    @ExceptionHandler(value = ParseException.class)
    @ResponseBody
    public ResponseData parseExceptionHandler(ParseException e){
        logger.error("����ת���쳣��ԭ����:",e);
        return new ResponseData("���ڸ�ʽ�����ˣ�");
    }


}
