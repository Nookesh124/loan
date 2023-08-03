package bank.loan.enitites;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loanofficer")
public class LoanOfficer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Officerid")
	private int officerid;
	
	@Column(name = "Officername")
	private String officername;
	
	@Column(name = "Loanid", insertable = false, updatable = false)
	private int loanid;
	
	@Column(name = "Managerid")
	private int managerid;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "Loanid", referencedColumnName = "Loanid")
	private LoanAccount loanaccount;

	public int getOfficerid() {
		return officerid;
	}

	public void setOfficerid(int officerid) {
		this.officerid = officerid;
	}

	public String getOfficername() {
		return officername;
	}

	public void setOfficername(String officername) {
		this.officername = officername;
	}

	public int getLoanid() {
		return loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public LoanAccount getLoanaccount() {
		return loanaccount;
	}

	public void setLoanaccount(LoanAccount loanaccount) {
		this.loanaccount = loanaccount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loanid, managerid, officerid, officername);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanOfficer other = (LoanOfficer) obj;
		return loanid == other.loanid && managerid == other.managerid && officerid == other.officerid
				&& Objects.equals(officername, other.officername);
	}

	@Override
	public String toString() {
		return "LoanOfficer [officerid=" + officerid + ", officername=" + officername + ", loanid=" + loanid
				+ ", managerid=" + managerid + "]";
	}	

}
