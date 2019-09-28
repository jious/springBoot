package test.service;

import boat.web.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.model.UserModel;

public interface UserService extends BaseService<UserModel> {

    /**
     * 分页
     * @param model 查询Model
     * @param pageable 分页信息
     * @return
     */
    Page<UserModel> findPage(UserModel model, Pageable pageable);


    /**
     * 删除数据
     * @param model
     * @return
     */
    void deleteById(UserModel model);
}

