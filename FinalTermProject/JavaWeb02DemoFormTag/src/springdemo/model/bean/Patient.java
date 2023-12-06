package springdemo.model.bean;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "patientTBL")
public class Patient implements Serializable{

	private static final long serialVersionUID=1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "hospitalFee")
    private double hospitalFee;

	public Patient() {
		
	}

	public Patient(Long id, String name, double hospitalFee) {
		this.id = id;
		this.name = name;
		this.hospitalFee = hospitalFee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id2) {
		this.id = id2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHospitalFee() {
		return hospitalFee;
	}

	public void setHospitalFee(double hospitalFee) {
		this.hospitalFee = hospitalFee;
	}


    
}

