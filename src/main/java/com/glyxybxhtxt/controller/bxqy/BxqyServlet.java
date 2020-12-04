package com.glyxybxhtxt.controller.bxqy;

import com.glyxybxhtxt.dataObject.Bxqy;
import com.glyxybxhtxt.response.ResponseData;
import com.glyxybxhtxt.service.BxqyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:wangzh
 * Date: 2020/12/4 15:46
 * Version: 1.0
 */
@RestController
public class BxqyServlet {
    private static final long serialVersionUID = 1L;
    @Autowired
    private BxqyService bs;

    @RequestMapping("/BxqyServlet")
    @ResponseBody
    ResponseData bxqyServlet(@RequestParam("op")String op, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(StringUtils.isWhitespace(op) || StringUtils.isEmpty(op) || StringUtils.isBlank(op))
            return new ResponseData("2");
        switch (op){
            case "selqybyid" : return selqybyid(request,response);
            default: return new ResponseData(false);
        }
    }

    @ResponseBody
    private ResponseData selqybyid(HttpServletRequest request,
                                      HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        Bxqy bq = bs.selbxqy(Integer.parseInt(request.getParameter("qid")));
        map.put("bxqy", bq);
        return new ResponseData(map);
    }
}
