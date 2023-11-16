class Coordenador extends Professor {
    private String horarioDeAtendimento;

    

    public Coordenador(String curso, String matricula, Aluno[] turma, String horarioDeAtendimento) {
        super(curso, matricula, turma);
        this.horarioDeAtendimento = horarioDeAtendimento;
    }
    
    

    void solicitacaoAluno(Aluno aluno) {
        if (aluno.isStatus()) {
            aluno.setStatus(false); 
        } else {
            aluno.setStatus(true); 
        }
    }

    void removerTurma(Aluno aluno, Professor professor) {
        boolean alunoEncontrado = false;
        
        for (int i = 0; i < professor.getTurma().length; i++) {
            if (professor.getTurma()[i] == aluno) {
                professor.getTurma()[i] = null; 
                alunoEncontrado = true;
                break;
            }
        }

        if (!alunoEncontrado) {
            throw new RuntimeException("O aluno não está presente na turma.");
        }
    }



    public String getHorarioDeAtendimento() {
        return horarioDeAtendimento;
    }



    public void setHorarioDeAtendimento(String horarioDeAtendimento) {
        this.horarioDeAtendimento = horarioDeAtendimento;
    }
}
