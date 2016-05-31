package com.spring.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
        @Autowired
        private SqlSession sqlSession;
        private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
        
        /**
         * Simply selects the home view to render by returning its name.
         */
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView home(Locale locale, Model model) {
                logger.info("Welcome home! The client locale is {}.", locale);
                // 메시지 모델에 추가.
                String sMessage = "스프링+마이바티스 첫만남. I Love Spring Framework!";
                model.addAttribute("sMessage", sMessage);
                
                // 날짜 부분 출력 및 모델에 추가
                Date date = new Date();
                DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
                String formattedDate = dateFormat.format(date);
                model.addAttribute("serverTime", formattedDate);
                
                // mybatis를 활용 db조회 모델에 추가
                HashMap<String, String> executeQuery = new HashMap<String, String>();
                executeQuery.put("name", "shin");
                List<HashMap<String, String>> resultSet = sqlSession.selectList("userControlMapper.R01", executeQuery);
                model.addAttribute("rs", resultSet);
                
                System.out.print(model.toString());
                

                // view에 모델 넘겨 넘겨
                ModelAndView mav = new ModelAndView("home", "model", model);
                return mav;
        }
}