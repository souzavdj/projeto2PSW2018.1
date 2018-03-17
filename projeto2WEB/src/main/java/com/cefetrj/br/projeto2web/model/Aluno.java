/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.projeto2web.model;

/**
 * Classe modelo para Alunos. 
 * @author vinicius
 * @version 2.0
 */
public class Aluno {
    
    /**
     * Atributo name é do tipo String e é responsável por armazenar o nome do Aluno.
     */
    private String name;
    
    /**
     * Atributo frequency é do tipo double e é responsável por armazenar a frequência do Aluno.
     */
    private double frequency;
    
    /**
     * Atributo nota1 é do tipo double e é responsável por armazenar a nota da primeira prova do Aluno.
     */
    private double nota1;
    
    /**
     * Atributo finalWork é do tipo double e é responsável por armazenar a nota do trabalho final do Aluno.
     */
    private double finalWork;
    
    /**
     * Atributo classProject é do tipo double e é responsável por armazenar a nota final dos trabalho de sala de aula do Aluno.
     */
    private double classProject;
    
    /**
     * Atributo pF é do tipo double e é responsável por armazenar a nota da prova final do Aluno.
     */
    private double pF;
    
    /**
     * Atributo DISAPPROVED é tipo String com valor "Reprovado".
     */
    final static String DISAPPROVED = "Reprovado";
    
    /**
     * Atributo APPROVED é tipo String com valor "Aprovado".
     */
    final static String APPROVED = "Aprovado";
    
    /**
     * Construtor padrão.
     */
    public Aluno () {
        super();
    }
    
    /**
     * Contrutor com todos os atributos.
     * @param name variável String com o nome do Aluno
     * @param frequency variável double com a frequência do Aluno na disciplina em porcentagem
     * @param nota1 variável double com a nota da primeira prova do aluno
     * @param finalWork variável double com a nota do trabalho final do aluno
     * @param classProject variável double com a nota dos trabalhos em sala feitos pelo aluno 
     * @param pF variável double com a nota da prova final do aluno
     */
    public Aluno(String name, double frequency, double nota1, double finalWork, double classProject, double pF) {
        super();
        this.name = name;
        this.frequency = frequency;
        this.nota1 = nota1;
        this.finalWork = finalWork;
        this.classProject = classProject;
        this.pF = pF;
    }
    
    /**
     * Método que retorna o nome do aluno.
     * @return o atributo {@link #name}
     */
    public String getName() {
        return name;
    }
    
    /**
     * Método para atribuir valor ao atributo nome.
     * @param name variável com o nome a ser inserido no atributo {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Método que retorna a frequência do aluno.
     * @return o atributo {@link #frequency}
     */
    public double getFrequency() {
        return frequency;
    }
    
    /**
     * Método para atribuir valor ao atributo frequency.
     * @param frequency variável com a frequência a ser inserido no atributo {@link #frequency}
     */
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
    
    /**
     * Método que retorna a nota 1 do aluno.
     * @return o atributo {@link #nota1}
     */
    public double getNota1() {
        return nota1;
    }
    
    /**
     * Método para atribuir valor ao atributo nota1.
     * @param nota1 variável com a primeira a ser inserido no atributo {@link #nota1}
     */
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }
    
    /**
     * Método que retorna a nota do trabalho final do aluno.
     * @return o atributo {@link #finalWork}
     */
    public double getFinalWork() {
        return finalWork;
    }
    
    /**
     * Método para atribuir valor ao atributo finalWork.
     * @param finalWork variável com a nota do trabalho final a ser inserido no atributo {@link #finalWork}
     */
    public void setFinalWork(double finalWork) {
        this.finalWork = finalWork;
    }

    /**
     * Método que retorna a nota dos trabalhos de aula do aluno.
     * @return o atributo {@link #classProject}
     */
    public double getClassProject() {
        return classProject;
    }
    
    /**
     * Método para atribuir valor ao atributo classProject.
     * @param classProject variável com a nota dos trabalhos de aula a ser inserido no atributo {@link #classProject}
     */
    public void setClassProject(double classProject) {
        this.classProject = classProject;
    }
    
    /**
     * Método que retorna a nota da prova final do aluno.
     * @return o atributo {@link #pF}
     */
    public double getpF() {
        return pF;
    }
    
    /**
     * Método para atribuir valor ao atributo pF.
     * @param pF variável com a nota da prova final a ser inserido no atributo {@link #pF}
     */
    public void setpF(double pF) {
        this.pF = pF;
    }
    
    /**
     * Método para verificar a situação do aluno (Aprovado ou Reprovado) na disciplina PSW.
     * @return retorna uma String com a situação do aluno (Aprovado ou Reprovado).
     */
    public String situation () {
        double M1;
        M1 = 0.7 * ((this.nota1 + this.finalWork) / 2) + this.classProject * 0.3;
        
        if(this.frequency >= 75.0){
            if(M1 >= 7.0) 
                return APPROVED;
            else if (M1 < 3.0) 
                return DISAPPROVED;
            else{
                //System.out.println("Prova Final");
                if( ((this.pF + M1) / 2) >= 5.0)
                    return APPROVED;
                else
                    return DISAPPROVED;
            }
        }else{
            return DISAPPROVED;
        }
    }
    public String toString () {
        return name;
    }
}
