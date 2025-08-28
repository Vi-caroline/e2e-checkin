package br.com.e2etreinamentos.checkin_e2e.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.e2etreinamentos.checkin_e2e.model.CheckinModel;
import br.com.e2etreinamentos.checkin_e2e.service.CheckinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/checkins")
public class CheckinController {

	private final CheckinService service;

	public CheckinController(CheckinService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Map<String, String> body) {
		String email = body.get("email");
		LocalDate date = LocalDate.parse(body.get("lessonDate"));
		return ResponseEntity.ok(service.createCheckin(email, date));
	}

	@GetMapping("/pending")
	public List<CheckinModel> pending() {
		return service.findPending();
	}

	@PostMapping("/{id}/approve")
	public CheckinModel approve(@PathVariable Long id) {
		return service.approve(id);
	}

	@PostMapping("/{id}/reject")
	public CheckinModel reject(@PathVariable Long id, @RequestBody(required = false) Map<String, String> body) {
		String reason = body != null ? body.getOrDefault("reason", "") : "";
		return service.reject(id, reason);
	}
}
