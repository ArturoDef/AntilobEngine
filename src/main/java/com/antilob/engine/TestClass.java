package com.antilob.engine;

import com.antilob.engine.database.entity.Member;
import com.antilob.engine.service.IDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class TestClass {
    private final IDataService dataService;

    ApplicationContext context;
    public TestClass(ApplicationContext context) {
        this.context = context;
        dataService = (IDataService) context.getBean("dataService");
    }

    public void displayMemberList(){
        List<Member> list= dataService.getMemberList();
        for(Member member:list){
            System.out.println(member.getLastname());
        }
    }
    public void getMemberList(){
        List<Member> list= dataService.getMemberList();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonArray
                    = objectMapper.writeValueAsString(list);
            System.out.println(jsonArray);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
