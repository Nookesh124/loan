package bank.loan.enitites;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loanaccount")
public class LoanAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Loanid")
	private int loanid;
	
	@Column(name = "Customername")
	private String customername;
	
	@Column(name = "Loantype")
	private String loantype;
	
	@Column(name = "Loanamount")
	private Double loanamount;
	
	@Column(name = "Approvalstatus")
	private String status;
	
	@OneToOne(mappedBy = "loanaccount")
	@JsonIgnore
	private LoanOfficer loanofficer;
	
	@OneToOne(mappedBy = "loanAccount")
	@JsonIgnore
	private LoanApprovalManager loanmanager;

	public int getLoanid() {
		return loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public Double getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(Double loanamount) {
		this.loanamount = loanamount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public LoanOfficer getLoanofficer() {
		return loanofficer;
	}

	public void setLoanofficer(LoanOfficer loanofficer) {
		this.loanofficer = loanofficer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customername, loanamount, loanid, loantype, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanAccount other = (LoanAccount) obj;
		return Objects.equals(customername, other.customername) && Objects.equals(loanamount, other.loanamount)
				&& loanid == other.loanid && Objects.equals(loantype, other.loantype)
				&& Objects.equals(status, other.status);
	}
	
	
}
