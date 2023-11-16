import java.util.Random;

class Professor implements IOperacoes {
    private String curso;
    private String matricula;
    private Aluno[] turma = new Aluno[10];

    
    

    public Professor(String curso, String matricula, Aluno[] turma) {
        this.curso = curso;
        this.matricula = matricula;
        this.turma = turma;
    }
    

    public String getCurso() {
        return curso;
    }


    public void setCurso(String curso) {
        this.curso = curso;
    }


    public String getMatricula() {
        return matricula;
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public Aluno[] getTurma() {
        return turma;
    }


    public void setTurma(Aluno[] turma) {
        this.turma = turma;
    }


    @Override
    public double media() {
        double somaNotas = 0;
        int alunosComNota = 0;

        for (Aluno aluno : turma) {
            if (aluno != null) {
                double mediaAluno = aluno.media();
                if (mediaAluno == -1) {
                    throw new RuntimeException("A turma ainda não foi finalizada. Aluno com nota pendente.");
                }
                somaNotas += mediaAluno;
                alunosComNota++;
            }
        }

        if (alunosComNota == 0) {
            throw new RuntimeException("Não há alunos na turma.");
        }

        return somaNotas / alunosComNota;
    }

    @Override
    public void presenca() {
        Random random = new Random();

        for (Aluno aluno : turma) {
            if (aluno != null) {
                double chancePresenca = random.nextDouble();
                if (chancePresenca >= 0.8) {
                    aluno.getPresencas()[random.nextInt(20)] = false; 
                } else {
                    aluno.getPresencas()[random.nextInt(20)] = true; 
                }
            }
        }
    }
}


