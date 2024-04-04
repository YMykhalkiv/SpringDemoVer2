package com.example.springdemover2.reporitory;

import com.example.springdemover2.model.DotaCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DotaCharacterRepository
        extends CrudRepository<DotaCharacter, Integer> {

//    @Query(value = "SELECT d FROM DotaCharacter d")
//    public List<DotaCharacter> getDotaCharacters();


}
