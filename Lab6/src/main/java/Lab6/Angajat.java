package Lab6;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Angajat {
    private String nume;
    @JsonProperty("post")
    private String post;
    private LocalDate dataAngajarii;
    @JsonProperty("salariu")
    private float salariu;

    public Angajat() {}
    public Angajat(String nume, String post, LocalDate dataAngajarii, float salariu) {
        this.nume = nume;
        this.post= post;
        this.dataAngajarii = dataAngajarii;
        this.salariu = salariu;
    }
    //get
    public String getNume() {return nume;}
    public String getPostul() {return post;}
    public LocalDate getDataAngajarii() {return dataAngajarii;}
    public float getSalariul() {return salariu;}

    //set
    public void setNume(String nume) {this.nume = nume;}
    public void setPostul(String post) {this.post = post;}
    public void setDataAngajarii(LocalDate dataAngajarii) {this.dataAngajarii = dataAngajarii;}
    public void setSalariul(float salariu) {this.salariu = salariu;}

    @Override
    public String toString() {
        return nume + "," + post + "," + dataAngajarii + "," + salariu;
    }

}
