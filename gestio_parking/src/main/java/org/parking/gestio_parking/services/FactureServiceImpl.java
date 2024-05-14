package org.parking.gestio_parking.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.parking.gestio_parking.Dto.FactureDto;
import org.parking.gestio_parking.Exceptions.ExceptionFactureNotFound;
import org.parking.gestio_parking.entities.Facture;
import org.parking.gestio_parking.mappers.FactureMppers;
import org.parking.gestio_parking.repositories.Facturerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class FactureServiceImpl implements FactureService {
    @Autowired
    private Facturerepository facturerepository;
    @Autowired
    private FactureMppers factureMppers;

    @Override
    public FactureDto saveFacture(FactureDto factureDto) {
        Facture facture=factureMppers.fromFactureDto(factureDto);
        facturerepository.save(facture);
        return factureMppers.fromFacture(facture);
    }

    @Override
    public FactureDto updateFacture(int id, FactureDto factureDto) throws ExceptionFactureNotFound {
        Facture facture = facturerepository.findById(id).orElseThrow(()->new ExceptionFactureNotFound("Facture not found"));
        Facture newfacture=factureMppers.fromFactureDto(factureDto);
        facture.setDate(newfacture.getDate());
        facture.setPrix(newfacture.getPrix());
        facture.setTva(newfacture.getTva());
        return factureMppers.fromFacture(facture);
    }

    @Override
    public List<FactureDto> listeFacture() {
        List<Facture> factureList = facturerepository.findAll();
        return factureList.stream().map(fct->factureMppers.fromFacture(fct)).collect(Collectors.toList());

    }

    @Override
    public FactureDto factureById(int id) throws ExceptionFactureNotFound {
        Facture facture = facturerepository.findById(id).orElseThrow(()->new ExceptionFactureNotFound("Facture not found"));
        return factureMppers.fromFacture(facture);
    }

    @Override
    public void deleteFacture(int id) {
        facturerepository.deleteById(id);

    }
}
