package applicationhopital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import applicationhopital.entities.Hopital;
import applicationhopital.entities.ReservationLit;
import applicationhopital.entities.Specialisation;
import applicationhopital.service.ApplicationHopitalService;

@Controller
public class ApplicationHopitalController {

	@Autowired
	ApplicationHopitalService applicationHopitalService;

	@RequestMapping("/home")
	public String homePage(Model model) throws Exception {

		List<Specialisation> specialisations = applicationHopitalService.afficherSpecialisations();
		model.addAttribute("specialisations", specialisations);

		return "hopitaux";

	}

	@RequestMapping("/hopitals")

	public String rechercherHopital(Model model, @RequestParam(name = "codeSpecialisation") Long codeSpecialisation,
			@RequestParam(name = "localisation") String localisation) throws Exception {

		Hopital hopital = applicationHopitalService.rechercherHopital(codeSpecialisation, localisation);
		model.addAttribute("hopital", hopital);
		model.addAttribute("codeSpecialisation", codeSpecialisation);
		model.addAttribute("localisation", localisation);

		return "DetailHopital";
	}

	@GetMapping("/reservationLit")

	public String reserverLit(Model model,

			@RequestParam(name = "codeHopital") Long codeHopital,
			@RequestParam(name = "codeSpecialisation") Long codeSpecialisation,
			@RequestParam(name = "nomPatient") String nomPatient,
			@RequestParam(name = "prenomPatient") String prenomPatient) throws Exception {

		ResponseEntity<ReservationLit> reservationLitResponse = applicationHopitalService.reservationLit(codeHopital,
				codeSpecialisation, nomPatient, prenomPatient);

		String messageErreur = null;
		String messageSucces = null;

		if (reservationLitResponse.getStatusCode().is2xxSuccessful()) {

			messageSucces = "La reservation a été fait avec succès";
		} else {

			messageErreur = "Peoblème lors de la réservation d'un lit";
		}

		model.addAttribute("messageErreur", messageErreur);
		model.addAttribute("messageSucces", messageSucces);

		return "DetailHopital";
	}

}
