package com.example.databasefakultas;

public class Fakultas {

    //Deklarasi Atribut fakultas
    public String idFk;
    public String fakName;

    public static final String TABLE_FK = "fakultas";
    public static final String KEY_FK_ID = "id_fk";
    public static final String KEY_FK_NAME = "fk_name";

    //Deklarasi Construktor Fakultas dengan parameter id dan nama
    public Fakultas(String idFk, String fakName) {
        this.idFk = idFk;
        this.fakName = fakName;
    }

    //Deklarasi Construktor Fakultas tanpa parameter
    public Fakultas(){

    }

    //Deklarasi method Accessor dan Muttator
    public String getIdFk() {
        return idFk;
    }

    public void setIdFk(String idFk) {
        this.idFk = idFk;
    }

    public String getFakName() {
        return fakName;
    }

    public void setFakName(String fakName) {
        this.fakName = fakName;
    }
}
