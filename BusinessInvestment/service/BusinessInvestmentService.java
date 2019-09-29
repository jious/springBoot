package logic.BusinessInvestment.service;

import boat.web.service.BaseService;
import logic.BusinessInvestment.model.BusinessInvestmentModel;
import logic.cooperative.mode.CooperativeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BusinessInvestmentService extends BaseService<BusinessInvestmentModel> {
    /**
     * 分页
     *
     * @param model    查询Model
     * @param pageable 分页信息
     * @return
     */
    Page<BusinessInvestmentModel> findPage(BusinessInvestmentModel model, Pageable pageable);
}
