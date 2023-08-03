package bank.loan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import bank.loan.enitites.LoanAccount;
import jakarta.transaction.Transactional;

public interface LoanAccountRepository extends JpaRepository<LoanAccount, Integer> {
	
	LoanAccount findByStatus(String status);
	@Modifying
	@Transactional
	void deleteAllByStatus(String status);

}
