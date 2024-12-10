package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> findAll();
    public Album findById(Long id);

}
