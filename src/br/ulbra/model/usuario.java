package br.ulbra.model;

/**
 *
 * @author ponei
 */
public class usuario {
    private int idUsu;
    private String nomeUsu;
    private String emailUsu;
    private String senhaUsu;

    public usuario() {
    }

    public usuario(int idUsu, String nomeUsu, String emailUsu, 
            String senhaUsu) {
        this.idUsu = idUsu;
        this.nomeUsu = nomeUsu;
        this.emailUsu = emailUsu;
        this.senhaUsu = senhaUsu;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNomeUsu() {
        return nomeUsu;
    }

    public void setNomeUsu(String nomeUsu) {
        this.nomeUsu = nomeUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

    public String getSenhaUsu() {
        return senhaUsu;
    }

    public void setSenhaUsu(String senhaUsu) {
        this.senhaUsu = senhaUsu;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsu=" + idUsu + ", nomeUsu=" + nomeUsu + ", emailUsu=" + emailUsu + ", senhaUsu=" + senhaUsu + '}';
    }
    
    
}