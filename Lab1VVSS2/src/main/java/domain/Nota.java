package domain;

import repository.HasID;

import java.time.LocalDate;

public class Nota implements HasID<String> {
    private String id; // id-ul notei
    private String idStudent; // id-ul studentului
    private String idTema; // id-ul temei
    private double nota; // valoarea notei
    private LocalDate data; // data in care a fost predata tema

    /**
     * Class Constructor
     * @param id - id-ul notei
     * @param idStudent - id-ul studentului
     * @param idTema - id-ul temei
     * @param nota - valoarea notei
     * @param data - data in care a fost predata tema
     */
    public Nota(String id, String idStudent, String idTema, double nota, LocalDate data){
        this.id = id;
        this.idStudent = idStudent;
        this.idTema = idTema;
        this.nota = nota;
        this.data = data;
    }
    //public Nota implementare

    /**
     * @return id-ul studentului
     */
    public String getIdStudent() {
        return idStudent;
    }

    /**
     * @return id-ul temei
     */
    public String getIdTema() {
        return idTema;
    }

    /**
     * @return valoarea notei
     */
    public double getNota() {
        return nota;
    }

    /**
     * Modifica valoarea unei note
     * @param nota - noua valoarea a notei
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * @return data in care a fost predata nota
     */
    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return idStudent + "," + idTema + "," + nota + "," + data;
    }

    /**
     * @return id-ul notei
     */
    @Override
    public String getID() {
        return this.id;
    }

    /**
     * modifica id-ul notei
     * @param id - noul id
     */
    @Override
    public void setID(String id) {
        this.id = id;
    }

    /**
     * modifica id-ul studentului
     * @param idStudent - noul id
     */
    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    /**
     * modifica id-ul temei
     * @param idTema - noul id
     */
    public void setIdTema(String idTema) {
        this.idTema = idTema;
    }
}
