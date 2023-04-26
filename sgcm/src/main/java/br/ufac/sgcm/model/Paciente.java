package br.ufac.sgcm.model;
import java.io.Serializable;

public class Paciente implements Serializable{
    private Long id;
    private String cep;
    private String cidade;
    private String data_nascimento;
    private String email;
    private String endereco;
    private String estado;
    private String grupo_sanguineo;
    private String nome;
    // private String sexo;
    private Sexo sexo;
    private String telefone;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCep(){
        return cep;
    }
    public void setCep(String cep){
        this.cep = cep;
    }
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getDataNascimento(){
        return data_nascimento;
    }
    public void setDataNascimento(String data_nascimento){
        this.data_nascimento = data_nascimento;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getGrupoSanguineo(){
        return grupo_sanguineo;
    }
    public void setGrupoSanguineo(String grupo_sanguineo){
        this.grupo_sanguineo = grupo_sanguineo;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    // public String getSexo(){
    //     return sexo;
    // }
    // public void setSexo(String sexo){
    //     this.sexo = sexo;
    // }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public enum Sexo {
        M, F
    }

}