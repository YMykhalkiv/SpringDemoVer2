package com.example.springdemover2.service;

import com.example.springdemover2.model.DotaCharacter;

import java.util.List;

public interface DotaCharactersService {

    //add operation
    DotaCharacter saveDotaCharacter(DotaCharacter dotaCharacter);
    //read operation
    List<DotaCharacter> getAllDotaCharacters();
    // update operation
    DotaCharacter updateDotaCharacter(DotaCharacter dotaCharacter);
    //delete operation
    void deleteDotaCharacter(Integer characterId);
    //get operation
    DotaCharacter getDotaCharacter(int id);
    //attack operation
    String attack(int id1, int id2);
}
