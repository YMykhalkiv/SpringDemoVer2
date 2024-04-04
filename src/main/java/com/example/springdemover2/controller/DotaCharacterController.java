package com.example.springdemover2.controller;

import com.example.springdemover2.model.DotaCharacter;
import com.example.springdemover2.service.DotaCharactersServiceImpl;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dota/characters")
public class DotaCharacterController {

    @Autowired
    DotaCharactersServiceImpl dotaCharactersService;

    @GetMapping("")
    public List<DotaCharacter> getAllDotaCharacters() {
        return dotaCharactersService.getAllDotaCharacters();
    }

    @PostMapping("")
    public DotaCharacter addDotaCharacter( @RequestBody DotaCharacter dotaCharacter) {
        return dotaCharactersService.saveDotaCharacter(dotaCharacter);
    }

    @GetMapping("/{id}")
    public DotaCharacter getDotaCharacter(@PathVariable int id) {
        return dotaCharactersService.getDotaCharacter(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDotaCharacter(@PathVariable Integer id) {
        dotaCharactersService.deleteDotaCharacter(id);
        return "Character deleted";
    }

    @PatchMapping("/{id}")
    public DotaCharacter updateDotaCharacter(@PathVariable Integer id,@RequestBody DotaCharacter dotaCharacter) {
        dotaCharacter.setID(id);
        return dotaCharactersService.updateDotaCharacter(dotaCharacter);
    }

    @GetMapping("/{id1}/attack/{id2}")
    public String attack(@PathVariable int id1, @PathVariable int id2){
        if (id1 == id2)
            return "Characters cannot attack themselves";
        return dotaCharactersService.attack(id1, id2);
    }

}
