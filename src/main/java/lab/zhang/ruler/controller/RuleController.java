package lab.zhang.ruler.controller;

import com.alibaba.fastjson.JSON;
import lab.zhang.ruler.dto.RuleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author zhangrj
 */
@RestController
public class RuleController {

    private static final Logger logger = LoggerFactory.getLogger(RuleController.class);


    @GetMapping("/rules/{id}")
    RuleDto one(@PathVariable Long id) {
        RuleDto ruleDto = new RuleDto(1, "", true);
        return ruleDto;
    }

    @PostMapping("/rules")
    public RuleDto createRule(RuleDto ruleDto) {
        RuleDto newRuleDto = ruleDto;
//        try {
//            newRuleDto = JSON.parseObject(rule, RuleDto.class);
//        } catch (Exception e) {
//            logger.error("RuleController create parseObject exception, rule=" + rule, e);
//        }
        return newRuleDto;
    }
}
