import java.util.Arrays;

class Aluno implements IOperacoes {
    private String curso;
    private String matricula;
    private double[] notas = new double[3];
    private boolean[] presencas = new boolean[20];
    private boolean status;

    

    public Aluno(String curso, String matricula, double[] notas, boolean[] presencas, boolean status) {
        this.curso = curso;
        this.matricula = matricula;
        this.notas = notas;
        this.presencas = presencas;
        this.status = status;
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



    public double[] getNotas() {
        return notas;
    }



    public void setNotas(double[] notas) {
        this.notas = notas;
    }



    public boolean[] getPresencas() {
        return presencas;
    }



    public void setPresencas(boolean[] presencas) {
        this.presencas = presencas;
    }



    public boolean isStatus() {
        return status;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }



    @Override
    public double media() {
        int faltas = 0;
        int notasPreenchidas = 0;
        double somaNotas = 0;

        // Calcula o número de faltas
        for (boolean presenca : presencas) {
            if (!presenca) {
                faltas++;
            }
        }

        // Verifica se há notas pendentes
        for (double nota : notas) {
            if (nota != 0) {
                notasPreenchidas++;
                somaNotas += nota;
            }
        }

        if (faltas > 5) {
            System.out.println("Reprovado por falta");
            return -1;
        } else if (notasPreenchidas < 3) {
            System.out.println("O aluno está com nota pendente");
            return -1;
        } else {
            double media = somaNotas / notasPreenchidas;
            if (media >= 7) {
                System.out.println("Aprovado por média");
                return media;
            } else if (media >= 5 && media < 7) {
                System.out.println("Aprovado");
                return media;
            } else {
                System.out.println("Reprovado");
                return media;
            }
        }
    }

    @Override
    public void presenca() {
        int faltas = 0;
        int presencas = 0;

        for (boolean presenca : this.presencas) {
            if (presenca) {
                presencas++;
            } else {
                faltas++;
            }
        }

        System.out.println("Faltas: " + faltas);
        System.out.println("Presenças: " + presencas);
    }
}


