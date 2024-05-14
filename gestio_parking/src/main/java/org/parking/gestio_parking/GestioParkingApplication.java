package org.parking.gestio_parking;

import org.parking.gestio_parking.Dto.*;
import org.parking.gestio_parking.Exceptions.ExceptionClientNotfound;
import org.parking.gestio_parking.entities.Admin;
import org.parking.gestio_parking.entities.Parking;
import org.parking.gestio_parking.entities.Place;
import org.parking.gestio_parking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.parking.gestio_parking.num.Etatplace.DESPO;

@SpringBootApplication
public class GestioParkingApplication {

    public static void main(String[] args)  {
        SpringApplication.run(GestioParkingApplication.class, args);
        /*ClientServiceImpl clientService= new ClientServiceImpl();
        int id =1;
        String Nom = "hello";
        ClientDto clientdto = new ClientDto();
        clientdto.setNom(Nom);
        clientdto.setEmail(Nom + "@gmail.com");
        clientdto.setPrenom(Nom + "Pre");
        clientdto.setTelephone(0000000);
        clientdto.setNom_utilisateur("ut" + Nom);
        clientdto.setAdresse_client("adresse" + Nom);

        System.out.println(clientService.ClientById(id));
        clientService.SaveClient(clientdto);
        */


    }
    @Autowired
    private ParkingService parkingService;
    private PlaceService placeService;

    private AdminService adminService;

    @Transactional
    public void saveAdminParkingAndPlaces(Admin admin, Parking parking, List<Place> places){



    }

    @Bean
    /* CommandLineRunner commandLineRunner(ClientService clientService){
        return args -> {

            System.out.println("etape1==============================================================");
            ClientDto clientdto = new ClientDto();
            clientdto.setNom("ZAK");
            clientdto.setEmail("ZAK@gmail.com");
            clientdto.setPrenom("ZAK Pre");
            clientdto.setTelephone(0000000);
            clientdto.setNom_utilisateur("ut ZAK");
            clientdto.setAdresse_client("adresse ZAK");
            System.out.println("etape2==============================================================");
            clientService.SaveClient(clientdto);

        };*/
    CommandLineRunner commandLineRunner(ParkingService parkingService,FactureService factureService,ReservationService reservationService,PlaceService placeService,AdminService adminService,ClientService clientService,VehiculeService vehiculeService){

        return args -> {
            System.out.println("creation park");
            System.out.println("etape1==============================================================");
            ClientDto clientdto = new ClientDto();
            clientdto.setNom("ZAK");
            clientdto.setEmail("ZAK@gmail.com");
            clientdto.setPrenom("ZAK Pre");
            clientdto.setTelephone(0000000);
            clientdto.setNom_utilisateur("ut ZAK");
            clientdto.setAdresse_client("adresse ZAK");
            System.out.println("etape2==============================================================");
            clientdto = clientService.SaveClient(clientdto);


            PlaceDto placeDto=new PlaceDto();
            List<PlaceDto> pl= new ArrayList<>();


            AdminDto adminDto = new AdminDto();
            adminDto.setAddress("eee");
            adminDto.setUsername("zzzz");
            AdminDto p= adminService.SaveAdmin(adminDto);
            System.out.println(p.getAdminId());

            ParkingDto parkingDto = new ParkingDto();
            parkingDto.setAdresse("aaaaa");
            parkingDto.setPrix(00);
            parkingDto.setRegions("marrakech");
            parkingDto.setTelephone(666666666);
            parkingDto.setNomber_place(11);
            parkingDto.setPlaces(pl);
            parkingDto.setAdminId(p.getAdminId());

            parkingDto = parkingService.SaveParking(parkingDto);

            parkingDto.setAdminId(p.getAdminId());
//            parkingDto = parkingService.SaveParking(parkingDto);

            for(int i=0;i<parkingDto.getNomber_place(); i++){
                placeDto.setEtatplace(DESPO);
                placeDto.setParkingId(parkingDto.getId_parking());
                placeService.SavePlace(placeDto);
                pl.add(placeDto);
            }
            VehiculeDto vehiculeDto = new VehiculeDto();
            vehiculeDto.setMatricule("matricule");
            System.out.println("save vehicule");
            vehiculeDto =vehiculeService.saveVehicule(vehiculeDto);
            System.out.println("etat1");
            ReservationDto reservationDto =new ReservationDto();
            //reservationDto = reservationService.saveresrvation(reservationDto);
            reservationDto.setVehiculeId(vehiculeDto.getId_vehicule());
            System.out.println(vehiculeDto.getId_vehicule());
            System.out.println(clientdto.getIdClient());
            reservationDto.setClientId(clientdto.getIdClient());
            reservationDto.setPlaceId(1);//nombre entre ou selectioné
            System.out.println("save resrrvation");
            reservationDto = reservationService.saveresrvation(reservationDto);
            FactureDto factureDto = new FactureDto();
            System.out.println(reservationDto.getId_Reservation());
            factureDto.setReservationID(reservationDto.getId_Reservation());
            factureDto=factureService.saveFacture(factureDto);








//            placeDto.setParkingDto(parkingDto);
//            parkingService.SaveParking(parkingDto);


        };



    }

}
