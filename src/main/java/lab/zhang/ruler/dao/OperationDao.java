package lab.zhang.ruler.dao;

import lab.zhang.ruler.pojo.Operation;
import org.springframework.stereotype.Repository;

/**
 * @author zhangrj
 */
@Repository
public interface OperationDao {
    Operation<?, ?> selectById(int id);
}
