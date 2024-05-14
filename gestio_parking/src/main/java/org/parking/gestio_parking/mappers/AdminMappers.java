package org.parking.gestio_parking.mappers;

import org.parking.gestio_parking.Dto.AdminDto;
import org.parking.gestio_parking.entities.Admin;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AdminMappers {
    public Admin fromAdminDto(AdminDto adminDto){
        Admin admin =new Admin();
        BeanUtils.copyProperties(adminDto,admin);
        return admin;
    }
    public AdminDto fromAdmin (Admin admin){
        AdminDto adminDto=new AdminDto();
        BeanUtils.copyProperties(admin,adminDto);
        return adminDto;
    }
}
