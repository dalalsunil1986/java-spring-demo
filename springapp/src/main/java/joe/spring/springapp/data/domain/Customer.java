package joe.spring.springapp.data.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The customer entity class.
 * 
 * @author jsicree
 *
 * NOTE: To run on Oracle Express, use the @GeneratedValue annotation 
 * with the strategy = GenerationType.SEQUENCE and the @SequenceGenerator
 * annotation. For mySQL, comment those annotations out and use the 
 * @GeneratedValue annotation with strategy = GenerationType.IDENTITY.
 * 
 */
@Entity(name="CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="springSeq")
//    @SequenceGenerator( name = "springSeq", sequenceName = "SPRING_SEQ")
	private Long id;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="BIRTH_DATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private Collection<Address> addresses = new ArrayList<Address>();

	@SuppressWarnings("unused")
	private Customer() {
	}

	public Customer(String firstName, String lastName, String userName, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.birthDate = birthDate;
	}

	public Customer(String firstName, String lastName, String userName, Date birthDate,
			HashSet<Address> addresses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.birthDate = birthDate;
		this.addresses = addresses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + 
				", firstName=" + firstName
				+ ", lastName=" + lastName 
				+ ", userName=" + userName 
				+ ", birthDate=" + birthDate + "]";
	}


}