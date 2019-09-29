package logic.BusinessInvestment.service.Impl;
import	java.awt.Desktop.Action;

import boat.web.util.BSUtil;
import logic.BusinessInvestment.model.BusinessInvestmentModel;
import logic.BusinessInvestment.repository.BusinessInvestmentRepository;
import logic.BusinessInvestment.service.BusinessInvestmentService;
import logic.cooperative.mode.CooperativeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusinessInvestmentImpl implements BusinessInvestmentService {

    @Autowired
    private BusinessInvestmentRepository repository;

    @Override
    public Page<BusinessInvestmentModel> findPage(BusinessInvestmentModel model, Pageable pageable) {
        model.pageable(pageable);
        model.setName(null == model.getName() ? null : "%" + model.getName() + "%");
        List<BusinessInvestmentModel> modelList = repository.findPage(model);
        long total = repository.findTotal(model);
        return new PageImpl<>(modelList, pageable, total);
    }

    @Override
    public BusinessInvestmentModel save(BusinessInvestmentModel businessInvestmentModel) {

        //校验企业名称 是否存在
        BSUtil.isNull(this.findByName(businessInvestmentModel.getName()), "招商名称已存在");
        ;

        repository.save(businessInvestmentModel);

        return this.findByName(businessInvestmentModel.getName());
    }

    private BusinessInvestmentModel findByName(String name) {
        BusinessInvestmentModel model = new BusinessInvestmentModel();
        model.setName(name);
        return repository.findOne(model);
    }


    @Override
    public BusinessInvestmentModel update(BusinessInvestmentModel businessInvestmentModel) {

        //校验名称
        if (!this.findById(businessInvestmentModel.getId()).getName().equals(businessInvestmentModel.getName())) {
            BSUtil.isNull(this.findByName(businessInvestmentModel.getName()), "招商名称已存在");
        }
        repository.update(businessInvestmentModel);
        return this.findByName(businessInvestmentModel.getName());
    }

    @Override
    public void delete(int i) {
        BusinessInvestmentModel model = new BusinessInvestmentModel();
        model.setId(i);
        repository.delete(model);
    }

    @Override
    public BusinessInvestmentModel findById(int i) {
        BusinessInvestmentModel model = new BusinessInvestmentModel();
        model.setId(i);
        return repository.findById(model);
    }
}
