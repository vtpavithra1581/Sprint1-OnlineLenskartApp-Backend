package com.capgemini.lenskart.controller;

 

import java.util.List;

 

import javax.validation.Valid;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.capgemini.lenskart.dto.AdminDTO;
import com.capgemini.lenskart.dto.CustomerDTO;
import com.capgemini.lenskart.dto.ProductDTO;
import com.capgemini.lenskart.exception.AdminNotFoundException;
import com.capgemini.lenskart.service.AdminService;

 

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminController {

 

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin")
    public ResponseEntity<AdminDTO> saveAdmin(@Valid @RequestBody AdminDTO adminDTO){
        return ResponseEntity.ok(adminService.saveAdmin(adminDTO));

    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        AdminDTO dto=adminService.getAdminById(id);
        if(dto != null) {
            return new ResponseEntity<AdminDTO>(dto,HttpStatus.OK);
        }
        throw new AdminNotFoundException("admin with id "+ id +"does not exist");

    }


     @DeleteMapping("/admin")
        public ResponseEntity<?> deleteUser(@PathVariable int id) {
           AdminDTO dto = adminService.getAdminById(id);
            if (dto != null) {
                return new ResponseEntity<Boolean>(adminService.deleteAdmin(dto), HttpStatus.OK);
        }
            return new ResponseEntity<String>("The Admin id " + id + " does not exists", HttpStatus.NOT_FOUND);
        }

     @PutMapping("/updateadmin")
        public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO dto) {
            return new ResponseEntity<AdminDTO>(adminService.updateAdmin(dto), HttpStatus.OK);
        }
     @GetMapping("/admin")
     public ResponseEntity<List<AdminDTO>> getAllAdmin() {
         List<AdminDTO> list=adminService.findALL();
         return new ResponseEntity<List<AdminDTO>>(list,HttpStatus.OK);

 

     }



 

    

 

        
}
