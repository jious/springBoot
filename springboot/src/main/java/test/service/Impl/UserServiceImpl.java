package test.service.Impl;/*
    @author : parry
    @Create : 2019-09-28 15:34
*/

import boat.web.util.BSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.model.UserModel;
import test.repository.UserRepository;
import test.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel save(UserModel userModel) {
        userRepository.save(userModel);

        return this.findByName(userModel.getUserName());
    }

    //查找名字
    public UserModel findByName(String userName) {
        UserModel model = new UserModel();
        model.setUserName(userName);

        return userRepository.findOne(model);
    }

    @Override
    public UserModel update(UserModel userModel) {
        BSUtil.notNull(this.findById(userModel.getId()),"用户id不存在");;
        userRepository.update(userModel);
        return this.findById(userModel.getId());
    }



    @Override
    public UserModel findById(int i) {
        UserModel userModel = new UserModel();
        userModel.setId(i);
        return userRepository.findById(userModel);
    }

    @Override
    public Page<UserModel> findPage(UserModel model, Pageable pageable) {

        return null;
    }

    @Override
    public void delete(int i) {
        UserModel userModel = new UserModel();
        userModel.setId(i);
        userRepository.delete(userModel);
    }

    @Override
    public void deleteById(UserModel userModel) {
        this.delete(userModel.getId());
    }
}
