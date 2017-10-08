package vend.model;

import java.io.Serializable;

/**
 *
 * @author Alcides Lemos
 */
public class Cliente implements Serializable{
    private String  nome,
                    login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
