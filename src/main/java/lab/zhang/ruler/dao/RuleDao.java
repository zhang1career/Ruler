package lab.zhang.ruler.dao;

import lab.zhang.ruler.pojo.Rule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangrj
 */
@Repository
public interface RuleDao {

    List<Rule> selectAll();

    Rule selectById(int id);

    void insert(Rule rule);

    void update(Rule rule);

    void delete(int id);
}
