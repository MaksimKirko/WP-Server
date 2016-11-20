package com.github.maximkirko.wpserver.datamodel;

/**
 * Created by MadMax on 20.11.2016.
 */
public class Photo {

    private Long id;
    private byte[] photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Photo() {

    }
}
