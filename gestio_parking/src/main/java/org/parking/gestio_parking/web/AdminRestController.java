package org.parking.gestio_parking.web;
import org.parking.gestio_parking.Dto.AdminDto;
import org.parking.gestio_parking.Exceptions.ExceptionAdminNotFound;
import org.parking.gestio_parking.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AdminRestController {
    private AdminService adminService;

    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping("/admins")
    public List<AdminDto> ListeAdmins(){return adminService.ListeAdmin();}


    @GetMapping("/admin/{id}")
    public AdminDto AdminById(@PathVariable(name = "id") int id) throws ExceptionAdminNotFound {
        return adminService.AdminById(id);
    }

    @DeleteMapping("/admin/{id}")
    public void Deleteadmin(@PathVariable int id ){adminService.DeleteAdmin(id);}


    @PostMapping("/admin")
    public AdminDto SaveAdmin(@RequestBody AdminDto adminDto){
        return adminService.SaveAdmin(adminDto);
    }


    @PutMapping("/admin/{id}")
    public AdminDto updateadmin(@PathVariable int id ,AdminDto adminDto) throws ExceptionAdminNotFound {
        return adminService.UpdateAdmin(id,adminDto);
    }
}
