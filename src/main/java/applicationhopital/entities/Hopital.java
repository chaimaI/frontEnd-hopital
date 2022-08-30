package applicationhopital.entities;

public class Hopital {

	private Long id;
	private String nomHopital;
	private String adresseHopital;
	private String specialite;
	private Long nombreLitDisponible;
	private Specialisation specialisation;

	public Hopital() {
		super();

	}

	public Hopital(Long id, String nomHopital, String adresseHopital, String specialite, Long nombreLitDisponible,
			Specialisation specialisation) {
		super();
		this.id = id;
		this.nomHopital = nomHopital;
		this.adresseHopital = adresseHopital;
		this.specialite = specialite;
		this.nombreLitDisponible = nombreLitDisponible;
		this.specialisation = specialisation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomHopital() {
		return nomHopital;
	}

	public void setNomHopital(String nomHopital) {
		this.nomHopital = nomHopital;
	}

	public String getAdresseHopital() {
		return adresseHopital;
	}

	public void setAdresseHopital(String adresseHopital) {
		this.adresseHopital = adresseHopital;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Long getNombreLitDisponible() {
		return nombreLitDisponible;
	}

	public void setNombreLitDisponible(Long nombreLitDisponible) {
		this.nombreLitDisponible = nombreLitDisponible;
	}

	public Specialisation getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
	}

	@Override
	public String toString() {
		return "Hopital [id=" + id + ", nomHopital=" + nomHopital + ", adresseHopital=" + adresseHopital
				+ ", specialite=" + specialite + ", nombreLitDisponible=" + nombreLitDisponible + ", specialisation="
				+ specialisation + "]";
	}

}
