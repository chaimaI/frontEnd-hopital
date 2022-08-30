package applicationhopital.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import applicationhopital.entities.Hopital;
import applicationhopital.entities.ReservationLit;
import applicationhopital.entities.Specialisation;

@Service
public class ApplicationHopitalServiceImpl implements ApplicationHopitalService {

	@Autowired
	Environment environment;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper mapper;

	@Override
	public List<Specialisation> afficherSpecialisations() throws Exception {

		String specialisationResponse = restTemplate
				.getForObject(environment.getProperty("backend.url") + "/urgences/specialisations", String.class);

		Specialisation[] specialisations = mapper.readValue(specialisationResponse, Specialisation[].class);
		return Arrays.asList(specialisations);

	}

	@Override
	public Hopital rechercherHopital(Long codeSpecialisation, String localisation) throws Exception {

		Hopital hopitalResponse = restTemplate.getForObject(environment.getProperty("backend.url")
				+ "urgences/hopitals?specialisation=" + codeSpecialisation + "&localisation=" + localisation,
				Hopital.class);

		return hopitalResponse;
	}

	@Override
	public ResponseEntity<ReservationLit> reservationLit(Long codeHopital, Long codeSpecialisation, String nomPatient,
			String prenomPatient) {

		return restTemplate.exchange(
				environment.getProperty("backend.url") + "hopitals/reservationLit/" + codeHopital + "/"
						+ codeSpecialisation + "/" + nomPatient + "/" + prenomPatient,
				HttpMethod.PUT, null, ReservationLit.class);

	}

}
