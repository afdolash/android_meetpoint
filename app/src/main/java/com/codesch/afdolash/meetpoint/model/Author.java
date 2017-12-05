package com.codesch.afdolash.meetpoint.model;

/**
 * Created by Afdolash on 11/4/2017.
 */

public class Author {
    private int id_user;
    private String nama_user;
    private String link_fb_user;
    private float rating_user;
    private String contact_user;
    private int umur_user;
    private String jenis_kelamin_user;

    public Author(int id_user, String nama_user, String link_fb_user, float rating_user, String contact_user, int umur_user, String jenis_kelamin_user) {
        this.id_user = id_user;
        this.nama_user = nama_user;
        this.link_fb_user = link_fb_user;
        this.rating_user = rating_user;
        this.contact_user = contact_user;
        this.umur_user = umur_user;
        this.jenis_kelamin_user = jenis_kelamin_user;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNama_user() {
        return nama_user;
    }

    public String getLink_fb_user() {
        return link_fb_user;
    }

    public float getRating_user() {
        return rating_user;
    }

    public String getContact_user() {
        return contact_user;
    }

    public int getUmur_user() {
        return umur_user;
    }

    public String getJenis_kelamin_user() {
        return jenis_kelamin_user;
    }
}
