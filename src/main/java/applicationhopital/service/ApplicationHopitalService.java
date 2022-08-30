package applicationhopital.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import applicationhopital.entities.Hopital;
import applicationhopital.entities.ReservationLit;
import applicationhopital.entities.Specialisation;

public interface ApplicationHopitalService {

	public List<Specialisation> afficherSpecialisations() throws Exception;

	public Hopital rechercherHopital(Long codeSpecialisation, String localisation) throws Exception;

	public ResponseEntity<ReservationLit> reservationLit(Long codeHopital, Long codeSpecialisation, String nomPatient,
			String prenomPatient);

}
