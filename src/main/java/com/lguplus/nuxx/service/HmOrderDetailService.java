package com.lguplus.nuxx.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.lguplus.nuxx.dto.*;
import com.lguplus.nuxx.entity.PhoneDetailEntity;
import com.lguplus.nuxx.repository.PhoneDetailRepository;

/** @name: Home order detail Service */
@Service
public class HmOrderDetailService {
	private final PhoneDetailRepository detailRepo;

	public HmOrderDetailService(PhoneDetailRepository r) {
		detailRepo = r;
	}

	/** @name: 휴대폰주문상세조회 */
	public List<PhoneDetailDTO> retrievePhoneOrderDetail(PhoneReqDTO req) {
		List<PhoneDetailDTO> out = new ArrayList<>();
		for (PhoneDetailEntity e : detailRepo.findByPhoneId(req.getId()))
			out.add(new PhoneDetailDTO(e.getId(), e.getPhoneId()));
		return out;
	}

	/** @name: 주문상세고객정보반영 */
	public void applyCustomerName(List<PhoneDetailDTO> details, CustDTO customer) {
		for (PhoneDetailDTO d : details)
			d.setCustNm(customer.getCustNm());
	}
}