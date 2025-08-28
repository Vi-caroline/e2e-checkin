# 📘 Documentação de Regras de Negócio — Sistema de Check-in

## 🎯 Visão Geral
O sistema de Check-in de Presença da **E2E Treinamentos** tem como objetivo registrar a presença dos alunos nas aulas, com validação do professor.  
Garante que a presença seja confirmada somente no **dia da aula**, evitando registros incorretos ou retroativos.

---

## 👥 Papéis

### Aluno
- Pode registrar seu check-in apenas no **dia da aula**.
- Deve informar um **e-mail válido** utilizado na plataforma.
- Não pode registrar presença retroativa ou antecipada.
- Só é permitido **um check-in por dia**.

### Professor
- Visualiza todos os check-ins pendentes de validação.
- Pode **aprovar** ou **rejeitar** cada check-in.
- Ao rejeitar, pode informar opcionalmente o **motivo**.
- Para aprovar/rejeitar é necessário realizar **login** com credenciais válidas da instituição.

---

## 🔄 Fluxo de Negócio

### 1. Registro de Check-in (Aluno)
1. Aluno acessa a tela de check-in no **dia da aula**.  
2. Informa **e-mail válido** e **data da aula**.  
3. O sistema valida:  
   - ❌ Não aceita datas passadas.  
   - ❌ Não aceita datas futuras.  
   - ✅ Apenas a data atual.  
4. Check-in é registrado como **PENDENTE**.

### 2. Aprovação/Rejeição (Professor)
1. Professor acessa a tela de **Aprovação**.  
2. Faz login com usuário e senha válidos.  
3. Visualiza a lista de check-ins **pendentes**.  
4. Para cada check-in:
   - ✔ Aprovar → status = **APROVADO**.  
   - ✖ Rejeitar → status = **REJEITADO** (motivo opcional).  

---

## 📜 Regras de Negócio
1. Check-in só pode ser feito **no dia da aula**.  
2. Apenas **um check-in por aluno por dia**.  
3. O e-mail informado deve ser **válido e único** para a data.  
4. Todo check-in inicia no status **PENDENTE**.  
5. Apenas **professores autenticados** podem aprovar/rejeitar.  
6. O motivo da rejeição é opcional, mas se informado será registrado.

---

## 📝 Cenários de Uso

- **Aluno presente** → check-in feito e aprovado pelo professor.  
- **Aluno ausente** → não há check-in → presença não validada.  
- **Tentativa de fraude** → check-in em data errada → rejeitado automaticamente.  
- **Rejeição pelo professor** → status final = REJEITADO, com ou sem motivo.

---

## 💡 Benefícios
- Evita fraudes em registro de presença.  
- Garante segurança e transparência.  
- Fornece histórico confiável para auditorias.  
- Simplicidade para professores e instituição.
