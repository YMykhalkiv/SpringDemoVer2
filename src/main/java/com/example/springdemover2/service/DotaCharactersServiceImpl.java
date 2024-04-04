package com.example.springdemover2.service;

import com.example.springdemover2.model.DotaCharacter;
import com.example.springdemover2.model.exceptions.CharacterNotFoundException;
import com.example.springdemover2.reporitory.DotaCharacterRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DotaCharactersServiceImpl implements DotaCharactersService{

    @Autowired
    DotaCharacterRepository dotacharacterRepository;
    @Override
    public DotaCharacter saveDotaCharacter(DotaCharacter dotaCharacter) {
        return dotacharacterRepository.save(dotaCharacter);
    }

    @Override
    public List<DotaCharacter> getAllDotaCharacters() {
        return (List<DotaCharacter>) dotacharacterRepository.findAll();
    }

    @SneakyThrows
    @Override
    public DotaCharacter updateDotaCharacter(DotaCharacter dotaCharacter) {
        //update the character
        DotaCharacter character = dotacharacterRepository.findById(dotaCharacter.getID()).orElseThrow(() -> new CharacterNotFoundException("Character not found"));

        if (dotaCharacter.getName() != null)
            character.setName(dotaCharacter.getName());
        if (dotaCharacter.getDamage() != 0)
            character.setDamage(dotaCharacter.getDamage());
        if (dotaCharacter.getArmor() != 0)
            character.setArmor(dotaCharacter.getArmor());
        return dotacharacterRepository.save(character);
    }

    @Override
    public void deleteDotaCharacter(Integer characterId) {
        dotacharacterRepository.deleteById(characterId);
    }

    @SneakyThrows
    @Override
    public DotaCharacter getDotaCharacter(int id) {
        return dotacharacterRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException("Character not found"));
    }

    @Override
    public String attack(int id1, int id2) {
        DotaCharacter character1 = getDotaCharacter(id1);
        DotaCharacter character2 = getDotaCharacter(id2);
        int damage = (int) (character1.getDamage() *(1-(0.06 * character2.getArmor() / (1 + 0.06 * character2.getArmor()))));
        character2.setHealth(character2.getHealth() - damage);
        updateDotaCharacter(character2);
        return "Character 2 health: " + character2.getHealth() + " after attack from character 1";
    }
}
