package lab.zhang.ruler.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleControllerTest {
    private MockMvc mockMvc;

    private String cond;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RuleController target;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        cond = "{\"name\":\"and\",\"type\":31,\"value\":[{\"name\":\"=\",\"type\":30,\"value\":[{\"name\":\"在【赠礼】名单中\",\"type\":1,\"value\":\"isInGiftNamelist\"},{\"name\":\"真\",\"type\":0,\"value\":true}]},{\"name\":\">\",\"type\":22,\"value\":[{\"name\":\"年龄\",\"type\":1,\"value\":\"age\"},{\"name\":\"18\",\"type\":0,\"value\":18}]}]}";
    }


    @Test
    public void test_create() throws Exception {
        RequestBuilder request = null;
        //构造请求
        request = post("/rules")
                .param("id", "")
                .param("cond", cond)
                .param("dec", "true");
        //执行请求
        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status", not("E")))
//                .andExpect(content().string(containsString("选择浏览器打开即可")))
                .andDo(print())
                .andReturn();

        Assert.assertNotNull(result.getResponse().getContentAsString());
    }
}
