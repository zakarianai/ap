package org.parking.gestio_parking.web;

import lombok.AllArgsConstructor;
import org.parking.gestio_parking.Dto.FactureDto;
import org.parking.gestio_parking.Exceptions.ExceptionFactureNotFound;
import org.parking.gestio_parking.services.FactureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class FactureRestController {
    private FactureService factureService;

    @GetMapping("/factures")
    public List<FactureDto> listeFacture(){
        return factureService.listeFacture();
    }
    @GetMapping("/facture/{id}")
    public FactureDto getfacture(@PathVariable int id) throws ExceptionFactureNotFound {
        return factureService.factureById(id);
    }
    @PostMapping("/facture")
    public FactureDto savefacture(FactureDto factureDto){
        return factureService.saveFacture(factureDto);
    }
    @PutMapping("/facture")
    public FactureDto updateFacture(int id ,FactureDto factureDto) throws ExceptionFactureNotFound {
        return factureService.updateFacture(id,factureDto);
    }
    @DeleteMapping("/facture/{id}")
    public void deleteFacture(int id){
        factureService.deleteFacture(id);
    }

}
