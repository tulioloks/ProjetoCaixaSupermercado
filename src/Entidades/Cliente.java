package Entidades;

import Enums.TipoPessoa;

public class Cliente{

    private Integer id;

    private Pessoa pessoa;

    public Cliente() {};

    public Cliente(Integer id, Pessoa pessoa){
        this.id = id;
        this.pessoa = pessoa;

    }

    public Pessoa getPessoa() {
        return pessoa;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", pessoa=" + pessoa.toString() +
                '}';
    }
}