package logic.BusinessInvestment.repository;/*
import	java.util.Optional;
import	java.util.zip.Inflater;
    @author : parry
    @Create : 2019-09-29 09:50
*/

import boat.mybatis.lang.SimpleInsertLangDriver;
import boat.mybatis.lang.SimpleSelectLangDriver;
import boat.mybatis.lang.SimpleUpdateLangDriver;
import boat.mybatis.repository.MybatisRepository;
import logic.BusinessInvestment.model.BusinessInvestmentModel;
import logic.cooperative.mode.CooperativeModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BusinessInvestmentRepository extends MybatisRepository<BusinessInvestmentModel> {

    @Override
    @Lang(SimpleInsertLangDriver.class)
    @Insert("[#{model}]")
    int save(BusinessInvestmentModel model);

    @Override
    @Lang(SimpleUpdateLangDriver.class)
    @Insert("[#{model}]")
    int update(BusinessInvestmentModel model);

    @Override
    @Lang(SimpleSelectLangDriver.class)
    @Select("[#{model}] LIMIT 1")
    BusinessInvestmentModel findOne(BusinessInvestmentModel model);

    @Override
    @Lang(SimpleSelectLangDriver.class)
    @Select("[#{model}]")
    BusinessInvestmentModel findById(BusinessInvestmentModel model);
}
