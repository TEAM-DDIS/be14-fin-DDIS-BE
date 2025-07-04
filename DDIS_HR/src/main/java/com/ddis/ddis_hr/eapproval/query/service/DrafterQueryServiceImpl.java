package com.ddis.ddis_hr.eapproval.query.service;

import com.ddis.ddis_hr.eapproval.query.dto.FindDrafterQueryDTO;
import com.ddis.ddis_hr.eapproval.query.mapper.FindDrafterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrafterQueryServiceImpl implements DrafterQueryService {

    private final FindDrafterMapper findDrafterMapper;

    @Override
    public FindDrafterQueryDTO getfindDrafterInfo(Long employeeId) {
        return findDrafterMapper.findDrafterInfo(employeeId);
    }

}
