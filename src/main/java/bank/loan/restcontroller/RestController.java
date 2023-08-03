package bank.loan.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import bank.loan.enitites.LoanAccount;
import bank.loan.enitites.LoanApprovalManager;
import bank.loan.enitites.LoanOfficer;
import bank.loan.repositories.LoanAccountRepository;
import bank.loan.repositories.LoanApprovalManagerRepository;
import bank.loan.repositories.LoanOfficerRepository;
import io.swagger.v3.oas.annotations.Operation;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private LoanAccountRepository loanaccount;

	@Autowired
	private LoanOfficerRepository loanofficer;

	@Autowired
	private LoanApprovalManagerRepository loanapprovalmanager;

	@GetMapping("/loanaccounts")
	@Operation(summary = "Get All LoanAccounts",description = "Getting All LoanAccounts")
	public List<LoanAccount> getLoanAccounts() {
		return loanaccount.findAll();
	}

	@GetMapping("/loanofficers")
	@Operation(summary = "Get All LoanOfficer Details",description = "Getting All LoanOfficer Details")
	public List<LoanOfficer> getLoanOfficers() {
		return loanofficer.findAll();
	}

	@GetMapping("/loanapprovalmanagers")
	@Operation(summary = "Get All LoanApprovalManager Details",description = "Getting All LoanApprovalManager Details")
	public List<LoanApprovalManager> getManagers() {
		return loanapprovalmanager.findAll();
	}

	@PutMapping("/updateamount/{id}/{amount}")
	@Operation(summary = "Update Amount of LoanAccount by LoanId",description = "Updating amount of LoanAccount by LoanId")
	public LoanAccount updateAmount(@PathVariable("id") int id, @PathVariable("amount") Double amount) {
		var a = loanaccount.findById(id);
		if (a.isPresent()) {
			var b = a.get();
			b.setLoanamount(amount);
			loanaccount.save(b);
			return b;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No loan id is found");
		}
	}

	@GetMapping("/loanapprovalmanager/{id}")
	@Operation(summary = "Get Customer name from Manager id",description = "Getting customer name from manager id")
	public String getCustomerName(@PathVariable("id") int id) {
		var a = loanapprovalmanager.findById(id);
		var b = a.get().getLoanid();
		var c = loanaccount.findById(b).get().getCustomername();
		return c;
	}

	@GetMapping("/loanaccount")
	@Operation(summary = "Get Loan Status from loan id",description = "Getting Loan status from loan id")
	public String getApprovalStatus(@RequestParam("id") int id) {
		var a = loanaccount.findById(id).get();
		return a.getStatus();
	}

	@DeleteMapping("/loanaccount/status")
	@Operation(summary = "Delete LoanAccount by loan id",description = "Deleting LoanAccount by loan id")
	public void deleteAccount(@RequestParam("status") String status) {
		loanaccount.deleteAllByStatus(status);
	}
	
	@PostMapping("/loanaccount/application")
	@Operation(summary = "Add new LoanAccount details in LoanAccount",
	           description = "Adding LoanAccount details in LoanAccount")
	public LoanAccount addLoanAccount(@RequestBody LoanAccount account) {
		var v = loanaccount.findById(account.getLoanid());
		if(v.isPresent()) {
			throw new ResponseStatusException(HttpStatus.IM_USED,"Already id is here");
		}
		else {
			loanaccount.save(account);
			return account;
		}	
	}
	
	@GetMapping("/loanofficer/loanid")
	@Operation(summary = "Get LoanOfficer details by giving LoanAccount Loanid",
	           description = "Getting LoanOfficer details by gving LoanAccount Loanid")
	public LoanOfficer getLoanOfficers(@RequestParam("loanid") int loanid) {
		var v = loanofficer.findByLoanaccount_Loanid(loanid);
		return v;
	}
	
	@GetMapping("/loanofficer/manager")
	public LoanApprovalManager getLoanApprovalManagerByLoanOfficer(@RequestParam("id") int id) {
		var a = loanofficer.findById(id);
		var b = a.get().getManagerid();
		var c = loanapprovalmanager.findById(b).get();
		return c;
	}
}
