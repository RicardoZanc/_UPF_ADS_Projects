package model;

public class Aluno {
    // Aqui definimos os dados para o objeto. Em forma de variáveis!
    // Chamamos isso de atributo na OO. Cada variável é um atributo!
    private Integer matricula;
    private String nome;
    private Float nota1;
    private Float nota2;
    
    // M�todos construtores = inicializa��es = rodam quando instancia o objeto.

    public Aluno(Integer matricula, String nome, Float nota1, Float nota2) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Aluno(Integer matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Aluno(Integer matricula) {
        //Integer matricula;
        this.matricula = matricula;
    }

    public Aluno() {
    }
    
    // As funções são chamadas de métodos!
    public Float calcularMedia(){
       Float media = (nota1 + nota2) / 2;
       return media;
    }
    
    
    // daqui pra baixo os m�todos get e set de encapsulamento

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getNota1() {
        return nota1;
    }

   
    public void setNota1(Float nota1) throws Exception {
        // validar!!! se a nota for > 10 ou < 0 gerar erro de nota inv�lida
        if (nota1 < 0f || nota1 > 10f)
           throw new Exception("Nota inv�lida! Aceit�vel s� entre 0 e 10.");
        this.nota1 = nota1;
    }
    
    /*
    public String setNota1(Float nota1) {
        // validar!!! se a nota for > 10 ou < 0 gerar erro de nota inv�lida
        if (nota1 < 0f || nota1 > 10f)
           return "Nota inv�lida! Aceit�vel s� entre 0 e 10.";
        this.nota1 = nota1;
        return "";
    } 
    */
    
    public Float getNota2() {
        return nota2;
    }

    public void setNota2(Float nota2) throws Exception{
        // validar!!! se a nota for > 10 ou < 0 gerar erro de nota inv�lida
        if (nota2 < 0f || nota2 > 10f)
           throw new Exception("Nota inv�lida! Aceit�vel s� entre 0 e 10.");        
        this.nota2 = nota2;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + '}';
    }
    
    
    
    
}
