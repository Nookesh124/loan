package bank.loan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.loan.enitites.LoanApprovalManager;

public interface LoanApprovalManagerRepository extends JpaRepository<LoanApprovalManager, Integer>{

}
