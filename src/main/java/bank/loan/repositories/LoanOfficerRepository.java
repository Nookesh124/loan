package bank.loan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.loan.enitites.LoanOfficer;

public interface LoanOfficerRepository extends JpaRepository<LoanOfficer, Integer>{
	
	LoanOfficer findByLoanaccount_Loanid(int loanid);
	

}
