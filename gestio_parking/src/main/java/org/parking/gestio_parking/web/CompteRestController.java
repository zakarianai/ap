package org.parking.gestio_parking.web;

import lombok.AllArgsConstructor;
import org.parking.gestio_parking.Dto.CompteDto;
import org.parking.gestio_parking.Exceptions.ExceptionCompteNotFound;
import org.parking.gestio_parking.services.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CompteRestController {
    private CompteService compteService;
    @GetMapping("/compte/{id}")
    public CompteDto getCompteById(@PathVariable int id) throws ExceptionCompteNotFound {
        return compteService.compteById(id);
    }
    @GetMapping("/comptes")
    public List<CompteDto> listComptes(){
        return compteService.listCompte();
    }
    @PostMapping("/compte")
    public CompteDto saveCompte(@RequestBody CompteDto compteDto){
        return compteService.saveCompte(compteDto);
    }
    @PutMapping("/compte/{id}")
    public CompteDto updatecompte(@PathVariable int id ,@RequestBody CompteDto compteDto) throws ExceptionCompteNotFound {
        return compteService.updateCompte(id, compteDto);
    }
    @DeleteMapping("/compte/{id}")
    public void deleteCompte(@PathVariable int id){
        compteService.deleteCompte(id);
    }

}
