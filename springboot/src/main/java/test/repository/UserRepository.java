package test.repository;

import boat.mybatis.lang.SimpleDeleteLangDriver;
import boat.mybatis.lang.SimpleInsertLangDriver;
import boat.mybatis.lang.SimpleSelectLangDriver;
import boat.mybatis.lang.SimpleUpdateLangDriver;
import boat.mybatis.repository.MybatisRepository;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import test.model.UserModel;

@Mapper
@Repository
public interface UserRepository extends MybatisRepository<UserModel> {
    @Override
    @Lang(SimpleInsertLangDriver.class)
    @Insert("[#{userModel}]")
    int save(UserModel userModel);

    @Override
    @Lang(SimpleSelectLangDriver.class)
    @Select("[#{userModel}] LIMIT 1")
    UserModel findOne(UserModel model);

    @Override
    @Lang(SimpleUpdateLangDriver.class)
    @Update("[#{userModel}]")
    int update(UserModel userModel);

    @Override
    @Lang(SimpleSelectLangDriver.class)
    @Select("[#{userModel}]")
    UserModel findById(UserModel userModel);

    @Override
    @Lang(SimpleDeleteLangDriver.class)
    @Delete("[#{userModel}]")
    int delete(UserModel userModel);
}
