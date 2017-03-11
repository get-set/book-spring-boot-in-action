package com.getset.boottest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getset.boottest.dao.PersonRepository;
import com.getset.boottest.domain.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ch0903SpringbootTestApplicationTests {

	@Autowired
	PersonRepository personRepository;

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	String expctedJson;


	@Before
    public void setUp() throws JsonProcessingException {
        Person p1 = new Person("aaa", 1, "aaa-address");
        Person p2 = new Person("bbb", 1, "bbb-address");
        personRepository.save(p1);
        personRepository.save(p2);

        expctedJson = Obj2Json(personRepository.findAll(new Sort(Sort.Direction.ASC, "age")));
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String Obj2Json(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @Test
    public void testPersonController() throws Exception {
	    String uri = "/sort";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();

        Assert.assertEquals("错误，正确的返回值为200", 200, status);
        Assert.assertEquals("错误，返回值和预期返回值不一致", content.replaceAll("\\\\s*|\\t|\\r|\\n| ",""), expctedJson.replaceAll("\\\\s*|\\t|\\r|\\n| ",""));
    }
}
