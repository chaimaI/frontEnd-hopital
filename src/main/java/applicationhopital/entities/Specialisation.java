package applicationhopital.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Specialisation {

	private Long id;
	private String libelleSpecialisation;

	public Specialisation(Long id, String libelleSpecialisation) {
		super();
		this.id = id;
		this.libelleSpecialisation = libelleSpecialisation;
	}

	public Specialisation() {
		super();

	}

	@Override
	public String toString() {
		return "Specialisation [id=" + id + ", libelleSpecialisation=" + libelleSpecialisation + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelleSpecialisation() {
		return libelleSpecialisation;
	}

	public void setLibelleSpecialisation(String libelleSpecialisation) {
		this.libelleSpecialisation = libelleSpecialisation;
	}

}
