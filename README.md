# 📚 Sistema de Check-in — E2E Treinamentos

## 🔎 Sobre
Aplicação para controle de presença dos alunos da **E2E Treinamentos**, composta por:
- **Frontend Web** simples (HTML, CSS, JS).
- **Backend** com regras de negócio e persistência em banco MySQL.
- **Swagger UI** para documentação técnica.
- **Projeto** para ensinar os alunos automação de testes UI, API e Testes Unitários.

---

## 🚀 Funcionalidades
- Alunos registram check-in apenas no **dia da aula** usando e-mail válido.
- Professores autenticados aprovam ou rejeitam os check-ins.
- Motivo de rejeição é opcional.
- Relacionamento direto com regras de negócio de presença.

---

## 📖 Documentação de Negócio
As regras e fluxos estão descritos em [REGRAS_SISTEMA.md](./regras.sistemas.md).

---

## ▶️ Como executar (dev)
```bash
# compilar
mvn clean install

# rodar aplicação
mvn spring-boot:run
```

### Link da aplicação - Acesse:

Frontend → http://localhost:8084/index.html



### 📂 Estrutura de Pastas

checkin-e2e/
 ├─ src/main/java/br/com/e2etreinamentos/checkin_e2e/   # código backend
 ├─ src/main/resources/static/                           # frontend (html/css/js)
 ├─ src/test/java/...                                    # testes unitários
 ├─ pom.xml                                              # dependências Maven
 ├─ BUSINESS_RULES.md                                    # documentação de negócio
 └─ README.md


Acesse documentação de negócio regras.sistemas.md
