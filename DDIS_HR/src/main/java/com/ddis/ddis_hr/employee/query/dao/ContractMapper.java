package com.ddis.ddis_hr.employee.query.dao;

import com.ddis.ddis_hr.employee.query.dto.ContractListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContractMapper {

    List<ContractListDTO> selectAll();

    List<ContractListDTO> selectByEmployeeId(@Param("employeeId") Long employeeId);
}
