package joe.spring.springapp.data.reference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import joe.spring.springdomain.CountryDto;

/**
 * The country ref data class.
 * 
 * @author jsicree
 *
 * NOTE: To run on Oracle Express, use the @GeneratedValue annotation 
 * with the strategy = GenerationType.SEQUENCE and the @SequenceGenerator
 * annotation. For mySQL, comment those annotations out and use the 
 * @GeneratedValue annotation with strategy = GenerationType.AUTO.
 * 
 */
@Entity(name="COUNTRY")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="springSeq")
//    @SequenceGenerator( name = "springSeq", sequenceName = "SPRING_SEQ")
	private Long id;

	@Column(name="NAME")
	private String name;

	@Column(name="CODE")
	private String code;
	
	@SuppressWarnings("unused")
	private Country() {
		
	}

	public Country(final String name, final String code) {
		this.name = name;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
}