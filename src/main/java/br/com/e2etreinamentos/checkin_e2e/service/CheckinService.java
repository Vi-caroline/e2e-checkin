package br.com.e2etreinamentos.checkin_e2e.service;



import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern; // <-- este é o correto
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.e2etreinamentos.checkin_e2e.model.CheckinModel;
import br.com.e2etreinamentos.checkin_e2e.repository.CheckinRepository;

@Service
public class CheckinService {
    private final CheckinRepository repository;
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public CheckinService(CheckinRepository repository) { this.repository = repository; }

    @Transactional
    public CheckinModel createCheckin(String email, LocalDate lessonDate) {
        if (email == null || lessonDate == null) throw new IllegalArgumentException("E-mail e data são obrigatórios.");
        if (!EMAIL.matcher(email).matches()) throw new IllegalArgumentException("E-mail inválido.");
        LocalDate hoje = LocalDate.now();
        if (!lessonDate.isEqual(hoje)) throw new IllegalArgumentException("Check-in permitido apenas no dia da aula.");
        if (repository.existsByStudentEmailAndLessonDate(email, lessonDate))
            throw new IllegalStateException("Já existe check-in para este e-mail nesta data.");

        return repository.save(new CheckinModel(email, lessonDate));
    }

    @Transactional(readOnly = true)
    public List<CheckinModel> findPending() {
        return repository.findByStatusOrderByCreatedAtAsc(CheckinModel.Status.PENDING);
    }

    @Transactional
    public CheckinModel approve(Long id) {
        CheckinModel c = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Check-in não encontrado."));
        c.setStatus(CheckinModel.Status.APPROVED);
        return repository.save(c);
    }

    @Transactional
    public CheckinModel reject(Long id, String reason) {
        CheckinModel c = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Check-in não encontrado."));
        c.setStatus(CheckinModel.Status.REJECTED);
        // Se quiser persistir o motivo, crie um campo reason (String) no model e salve aqui.
        return repository.save(c);
    }
}


