package bank.loan.enitites;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loanapprovalmanager")
public class LoanApprovalManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Managerid")
	private int managerid;
	
	@Column(name = "Managername")
	private String managername;
	
	@Column(name = "Loanid")
	private int loanid;
	
	@Column(name = "Statusapproval")
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonIgnore
	@PrimaryKeyJoinColumn(name = "Loanid")
	private LoanAccount loanAccount;

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLoanid() {
		return loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public LoanAccount getLoanaccount() {
		return loanAccount;
	}

	public void setLoanaccount(LoanAccount loanaccount) {
		this.loanAccount = loanaccount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loanid, managerid, managername, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanApprovalManager other = (LoanApprovalManager) obj;
		return loanid == other.loanid && managerid == other.managerid && Objects.equals(managername, other.managername)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "LoanApprovalManager [managerid=" + managerid + ", managername=" + managername + ", loanid=" + loanid
				+ ", status=" + status + "]";
	}
}
